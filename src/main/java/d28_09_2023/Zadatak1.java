package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        1.Zadatak
//        Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//        Klik na Type drawdown
//        Klik na Public iz drowdowna
//        Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//        Kilk na Clear filter u desnom uglu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("#type-options summary")).click();
        driver.findElement(By.cssSelector("#type-options div.SelectMenu-list > label:nth-child(2)")).click();

        WebElement clearBtn = driver.findElement(By.cssSelector("a.issues-reset-query"));

        wait
        .withMessage("Clear button did not show after 10s.")
        .pollingEvery(Duration.ofMillis(200))
        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.issues-reset-query")));

        clearBtn.click();

        driver.quit();
    }
}
