package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        2. Zadatak
//        Napisati program koji ucitava stranicu https://youtube.com i u search baru unosi tekste Breskvica i ceka da se pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));

        driver.get("https://youtube.com");


        driver.findElement(By.cssSelector("input#search")).click();
        driver.findElement(By.cssSelector("input#search")).sendKeys("Bobby Lee");
        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("button#search-icon-legacy")).click();

        wait
                .withMessage("Less then 3 search suggestions loaded")
                        .pollingEvery(Duration.ofMillis(200))
                                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[role='presentation']"), 3));

        driver.findElements(By.cssSelector("[role='presentation'] div.sbse")).get(0).click();

        driver.quit();
    }
}
