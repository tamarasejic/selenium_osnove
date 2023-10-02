package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        2.Zadatak
//        Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik na svako dugme od PRIMARY do DARK
//        Sacekati da se toasts u desnom gornjem uglu pojavi
//        Pauza izmedju klikova 1s
//        Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(@id, 'basic-')]"));
        List<WebElement> tosts = driver.findElements(By.xpath("//div[contains(@id, 'basic-')]"));

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();
            wait
                    .withMessage("Toast id: " +  tosts.get(i).getAttribute("id") + "did not show")
                    .pollingEvery(Duration.ofMillis(200))
                    .until(ExpectedConditions.visibilityOf(tosts.get(i)));

            wait
                    .withMessage("Toast id: " +  tosts.get(i).getAttribute("id") + " did not disappear")
                    .pollingEvery(Duration.ofMillis(200))
                    .until(ExpectedConditions.visibilityOf(tosts.get(i)));

            Thread.sleep(1000);
        }
        driver.quit();
    }
}
