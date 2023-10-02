package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

//        5. Zadatak
//        Ucitati stranicu http://seleniumdemo.com/?product=bdd-cucumber
//        Klik na korpu iz gornjeg desnog ugla
//        Sacekati da naslov stranice bude Cart – Selenium Demo Page
//        Proveriti da li element koji prikazuje stanje korpe ima tekst Your cart is currently empty.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://seleniumdemo.com/?product=bdd-cucumber");

        new Actions(driver)
                .moveToElement(driver.findElement(By.cssSelector(".nav__woocart > a")))
                .click()
                .perform();
        wait
                .withMessage("Page title is not Cart – Selenium Demo Page")
                .until(ExpectedConditions.titleIs("Cart – Selenium Demo Page"));

        wait
                .withMessage("Cart text is not Your cart is currently empty.")
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.woocommerce p.cart-empty"), "Your cart is currently empty."));
        System.out.println("Cart text is Your cart is currently empty.");

        driver.quit();
    }
}
