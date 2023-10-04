package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import p02_10_2023.JavaDownloadFileFromURL;
import p02_10_2023.UrlHelpers;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {

//        4. Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://itbootcamp.rs/
//        Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//        Cita sve linkove slika iz slajdera
//        Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//        Azurirajte gitignore da ignorise itbootcamp_slider folder

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://itbootcamp.rs/");

        new Actions(driver)
                .scrollToElement(driver.findElement(By.className("owl-stage")))
                .perform();

        List<WebElement> imgLinks = driver.findElements(By.cssSelector(".carousel-item > img"));

        for (int i = 0; i < imgLinks.size(); i++) {
            String url = imgLinks.get(i).getAttribute("src");
            int statusCode = UrlHelpers.getHTTPResponseStatusCode(url);
            if (statusCode >= 200 && statusCode <  300) {
                JavaDownloadFileFromURL.downloadUsingNIO(url, "itbootcamp_slider/carouselImg-" + i + ".png");
            }
        }

        driver.quit();
    }
}
