package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) {

//        4.Zadatak
//        Ucitati stranicu http://seleniumdemo.com/?post_type=product
//        Klik na search dugme u gornjem desnom uglu
//        Cekati da forma za pretragu bude vidljiva
//        Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//        Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst koji je unet za pretragu.
//        Ispisati odgovarajuce poruke u terminalu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://seleniumdemo.com/?post_type=product");

        driver.findElement(By.cssSelector("ul.regular-nav a.search-toggle_btn")).click();
        wait
                .withMessage("Search form not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("search__wrapper")));

        new Actions(driver)
                .sendKeys(driver.findElement(By.cssSelector(".search__wrapper  input[name='s']")), "BDD Cucumber")
                .sendKeys(Keys.ENTER)
                .perform();

        List<WebElement> searchResults = driver.findElements(By.xpath("//article[contains(@id, 'post-')] // h2 / a"));
        wait
                .withMessage("Search result title does not contain search input text.")
                .until(ExpectedConditions.textToBePresentInElement(searchResults.get(0), "BDD Cucumber"));
        System.out.println("Search result title contains search input text.");

        driver.quit();
    }
}
