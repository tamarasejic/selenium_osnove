package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import p28_09_2023.Zadatak2.TestHelper;

import java.time.Duration;

public class UvodUTestng {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://google.com");
    }

    @Test
    public  void  googleTitleTest() {
//        System.out.println("Naslov " + driver.getTitle());
//        driver.navigate().to("https://facebook.com");
//        if (driver.getTitle().equals("Google")){
//            System.out.println("DOBRO JE");
//        } else{
//            System.out.println("NIJE DOBRO");
//        }
        Assert.assertTrue(driver.getTitle().contains("Google"), "Poruka");

        Assert.assertEquals(driver.getTitle(),
                "Google",
                "Home page title should be 'Google'");
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.google.com/",
                "IDE PORUKA");

//        TestHelper testHelper = new TestHelper(driver);
//        boolean elementExist = testHelper.elementExists(By.name("aasfaaf"));
//        Assert.assertFalse(elementExist);

        wait
                .withMessage("")
                .until(ExpectedConditions.numberOfElementsToBe(By.name("aasfaaf"), 0));

        WebElement searchInput = driver
                .findElement(By.name("q"));

        searchInput.sendKeys("it bootcamp");
        searchInput.sendKeys(Keys.ENTER);

        wait
                .withMessage("After search title should include 'it bootcamp' ")
                .until(ExpectedConditions.titleContains("it bootcamp"));
    }

//    @Test
//    public  void  googleSearchTest() {
//        driver.findElement(By.name("q"))
//                    .sendKeys("IT Bootcamp");
//        driver.navigate().to("https://youtube.com");
//    }

//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("After method");
//    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
