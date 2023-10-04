package p03_10_2023;
//        1.Zadatak
//        Kreirati klasu KatalonLoginTests za testove
//        Base url: https://cms.demo.katalon.com
//        Test #1: Visit login page from Nav bar
//        Koraci:
//        Ucitati home stranicu
//        Kliknuti na My account link
//        Verifikovati da je naslov stranice My account – Katalon Shop
//        Verifikovati da se u url-u stranice javlja /my-account
//        Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//        Test #2: Check input types
//        Koraci:
//        Ucitati /my-account stranicu
//        Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//        Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//        Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//        Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci informaciu da li je checkbox cekiran ili ne.
//        Za sve validacije ispisati odgovarajuce poruke u slucaju greske

//        Test #3: Display error when credentials are wrong
//        Podaci:
//        email: invalidemail@gmail.com
//        password: invalid123
//        Koraci:
//        Ucitati home stranicu
//        Kliknuti na My account link
//        Unesite email
//        Unesite password
//        Kliknite na login dugme
//        Verifikovati da postoji element koji prikazuje gresku
//        Verifikovati da je prikazana greska ERROR: Invalid email address
//        Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//        Verifikovati da smo idalje na login stranici posle greske, tako sto proveravamo da se url-u javlja /my-account
//
//        Test #4: Successful login with valid credentials
//        Podaci:
//        username: customer
//        password: crz7mrb.KNG3yxv1fbn
//        Koraci:
//        Ucitati home stranicu
//        Kliknuti na My account link
//        Unesite email
//        Unesite password
//        Kliknite na login dugme
//        Verifikovati da se pojavljuje link za logout na stranici



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonLoginTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com";

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethodLoadHomePage() {
        driver.navigate().to(baseUrl);
    }

    @Test (priority = 1)
    public void visitLoginPageFromNavBar() {
        driver.findElement(By.cssSelector("li.page-item-10 > a"))
                .click();
        wait
                .withMessage("Should be redirected to 'My account – Katalon Shop' page")
                .until(ExpectedConditions.titleIs("My account – Katalon Shop"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Url should contain '/my-account' ");
    }

    @Test  (priority = 2)
    public void checkInputTypes(){
        driver.findElement(By.cssSelector("li.page-item-10 > a"))
                .click();
        wait
                .withMessage("Should be redirected to 'My account – Katalon Shop' page")
                .until(ExpectedConditions.titleIs("My account – Katalon Shop"));

        Assert.assertEquals(driver
                .findElement(By.id("username"))
                .getAttribute("type"),
                "text",
                "Username input type attribute value should be 'text' ");

        Assert.assertEquals(driver
                        .findElement(By.id("password"))
                        .getAttribute("type"),
                "password",
                "Password input type attribute value should be 'password' ");

        Assert.assertEquals(driver
                        .findElement(By.id("rememberme"))
                        .getAttribute("type"),
                "checkbox",
                "Remember me checkbox input type attribute value should be 'checkbox' ");

        WebElement checkbox = driver.findElement(By.id("rememberme"));

        Assert.assertFalse(checkbox.isSelected(), "The checkbox selection state should be unchecked by default.");
    }

    @Test (priority = 3)
    public void displayErrorWhenCredentialsAreWrong () {
        String username = "invalidemail@gmail.com";
        String password = "invalid123";

        driver.findElement(By.cssSelector("li.page-item-10 > a"))
                .click();
        wait
                .withMessage("Should be redirected to 'My account – Katalon Shop' page")
                .until(ExpectedConditions.titleIs("My account – Katalon Shop"));

        driver.findElement(By.id("username"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);
        driver.findElement(By.name("login"))
                .click();
        wait
                .withMessage("Error message not shown when invalid email address is entered")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".woocommerce-error a")));
        wait
                .withMessage("Error message text 'ERROR: Invalid email address' not shown when invalid email address is entered")
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(By.cssSelector(".woocommerce-error li"), ": Invalid email address. "));

        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Url should contain '/my-account' ");

    }

    @Test (priority = 4)
    public void successfulLoginWithValidCredentials() {
        String username = "customer";
        String password = "crz7mrb.KNG3yxv1fbn";

        driver.findElement(By.cssSelector("li.page-item-10 > a"))
                .click();
        wait
                .withMessage("Should be redirected to 'My account – Katalon Shop' page")
                .until(ExpectedConditions.titleIs("My account – Katalon Shop"));

        driver.findElement(By.id("username"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);
        driver.findElement(By.name("login"))
                .click();

        wait
                .withMessage("Logout button is not present.")
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log out")));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
