package p05_10_2023;

//        Kreirati klasu SwagLabsTests https://www.saucedemo.com/
//
//        Before Method:
//        Ucitava home stranicu
//        Brise kolacice
//
//        Test #1:  Verify error is displayed when username is missing
//        Koraci:
//        Ucitati home stranicu
//        Klik na login dugme
//        Verifikovati da je prikazana poruka Epic sadface: Username is required
//
//        Test #2:  Verify error is displayed when password is missing
//        Koraci:
//        Ucitati home stranicu
//        Uneti username
//        Klik na login dugme
//        Verifikovati da je prikazana poruka Epic sadface: Password is required
//
//        Test #3:  Verify error is displayed when credentials are wrong
//        Podaci:
//        username: standard_user
//        password: invalidpassword
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je prikazana poruka Epic sadface: Username and password do not match any user in this service
//
//        Test #4:  Verify error is displayed when user is locked
//        Podaci:
//        username: standard_user
//        password: invalidpassword
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je prikazana poruka Epic sadface: Sorry, this user has been locked out.
//
//        Test #5:  Verify successful login
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html
//        Klik na Menu iz gornjeg lovog ugla
//        Sacekati da se prikaze meni
//        Verifikovati da Logout dugme postoji
//        Klik na logout
//        Verifikovati da je prikazana login forma
//
//        Test #5:  Adding Products to Cart
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html
//        Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//        Klik na Add to cart pored proizvoda.
//        Proverite da se pojavilo Remove dugme
//        Proverite da li se broj proizvoda u korpi povećao na 1.
//
//        Test #6: Viewing Product Details
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html
//        Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//        Proverite da li se prikazuju detalji proizvoda, uključujući cenu, opis i dugme za dodavanje u korpu
//
//        Test #7: Removing Products from Cart
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html
//        Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//        Klik na Add to cart pored proizvoda.
//        Proverite da li se broj proizvoda u korpi povećao na 1.
//        Kliknuti na korpu iz navigacije
//        Proverite da li se proizvod "Sauce Labs Backpack" ubacio u korpu.
//        Klik na Remove dugme pored proizvoda
//        Proverite da li se proizvod "Sauce Labs Backpack" izbacio iz korpe.
//
//        Test #8: Product Checkout
//        Podaci:
//        username: standard_user
//        password: secret_sauce
//        checkout name: Pera
//        checkout last name: Peric
//        checkout zip: 18000
//        Koraci:
//        Ucitati home stranicu
//        Uneti username i password
//        Klik na login dugme
//        Verifikovati da je url stranice /inventory.html
//        Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
//        Klik na Add to cart pored proizvoda.
//        Proverite da li se broj proizvoda u korpi povećao na 1.
//        Kliknuti na korpu iz navigacije
//        Klik na checkout dugme iz korpe
//        Unesite podatke za checkout formu
//        Klik na continue
//        Proverite da li su podaci na Checkout: Overview stranici ispravni
//        Klik na finish
//        Validirati da se prikazuje poruka za uspesno porucivanje Thank you for your order!

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://www.saucedemo.com/";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){

        driver.get(baseUrl);
    }

    @Test (priority = 1, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Message 'Epic sadface: Username is required' did not show.")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("error-message-container"),
                        "Epic sadface: Username is required"));

    }

    @Test(priority = 2, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "standard_user";

        driver.findElement(By.id("user-name"))
                        .sendKeys(username);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Message 'Epic sadface: Password is required' " +
                        "did not show after only Username input login.")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("error-message-container"),
                        "Epic sadface: Password is required"));

    }

    @Test (priority = 3, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Error message did not show after Invalid credentials input login.")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("error-message-container"),
                        "Epic sadface: Username and password do not match any user in this service"));

    }

    @Test (priority = 4, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Error Message did not show after Locked out User credentials input login.")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("error-message-container"),
                        "Epic sadface: Sorry, this user has been locked out."));

    }

    @Test (priority = 5, retryAnalyzer = SwagLabsRetry.class)
    public void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Successful login did not redirect to page https://www.saucedemo.com/inventory.html")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("react-burger-menu-btn"))
                .click();

        wait
                .withMessage("Menu did not show after click on menu button. ")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu-wrap")));

        wait
                .withMessage("Logout button did not show.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        driver.findElement(By.id("logout_sidebar_link"))
                .click();

        wait
                .withMessage("Login form did not show after logout.")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("login_button_container")));
    }

    @Test (priority = 6, retryAnalyzer = SwagLabsRetry.class)
    public void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Successful login did not redirect to page https://www.saucedemo.com/inventory.html")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        wait
                .withMessage("Remove button did not show after Add to cart click.")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));


        Assert.assertTrue(driver.findElement(By.className("shopping_cart_badge"))
                        .getText().equals("1"),
                "Number of products in the cart has not increased by one after Add to cart.");

    }

    @Test (priority = 7, retryAnalyzer = SwagLabsRetry.class)
    public void viewingProductDetails() throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Successful login did not redirect to page https://www.saucedemo.com/inventory.html")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        driver.findElement(By.className("inventory_item_name"))
                .click();


        wait
                .withMessage("Product details box not shown after Product click.")
                .until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_details_container")));

        wait
                .withMessage("Product image did not show.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_img")));

        wait
                .withMessage("Product description did not show.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_desc")));

        Assert.assertFalse(driver.findElement(By.className("inventory_details_desc"))
                        .getText().isEmpty(),
                "Description text box is empty.");

        Assert.assertFalse(driver.findElement(By.className("inventory_details_price"))
                        .getText().isEmpty(),
                "Price is not shown.");

        Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed(),
                "Add to cart button did not show.");

    }

    @Test (priority = 8, retryAnalyzer = SwagLabsRetry.class)
    public void removingProductsFromCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Successful login did not redirect to page https://www.saucedemo.com/inventory.html")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),
                "1",
                "Number of products in the cart has not increased by one after Add to cart.");

        driver.findElement(By.className("shopping_cart_link"))
                .click();

        Assert.assertEquals(productName,
                driver.findElement(By.className("inventory_item_name")).getText(),
                "Product " + productName + " is not shown in the cart.");

        driver.findElement(By.id("remove-sauce-labs-backpack"))
                .click();

        wait
                .withMessage("Product " + productName + " is still shown in the cart after Remove click.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("inventory_item_name")));

    }

    @Test (priority = 9, retryAnalyzer = SwagLabsRetry.class)
    public void productCheckout() {
        String username = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        wait
                .withMessage("Successful login did not redirect to page https://www.saucedemo.com/inventory.html")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        WebElement product = null;
        String productName = "Sauce Labs Backpack";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(productName)) {
                product = products.get(i);
            }
        }
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        Assert.assertTrue(driver.findElement(By.className("shopping_cart_badge"))
                        .getText().equals("1"),
                "Number of products in the cart has not increased by one after Add to cart.");

        driver.findElement(By.className("shopping_cart_link"))
                .click();


        Assert.assertTrue(driver.findElement(By.className("inventory_item_name"))
                        .getText().equals(productName),
                "Product " + productName + " is not shown in the cart.");

        driver.findElement(By.id("checkout"))
                .click();

        wait
                .withMessage("Checkout info box not shown after Checkout click.")
                .until(ExpectedConditions.presenceOfElementLocated(By.className("checkout_info")));

        driver.findElement(By.id("first-name"))
                .sendKeys(checkoutName);
        driver.findElement(By.id("last-name"))
                .sendKeys(checkoutLastName);
        driver.findElement(By.id("postal-code"))
                .sendKeys(checkoutZip);

        driver.findElement(By.id("continue"))
                .click();

        Assert.assertTrue(driver.findElement(By.className("inventory_item_name"))
                        .getText().equals(productName),
                "Product " + productName + " is not shown in the checkout.");


        Assert.assertTrue(driver.findElement(By.className("summary_subtotal_label"))
                        .getText().contains("29.99"),
                "Product total price does not contain 29.99.");

        driver.findElement(By.id("finish"))
                .click();
    }

    @AfterMethod
    private void afterMethod(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
