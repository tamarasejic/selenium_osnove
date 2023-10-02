package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

//        6.Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//        Ceka da broj toasts-a bude 4
//        Ispisuje poruku, toasts su prikazani
//        Ceka da broj toasts-a bude 0
//        Ispisuje poruku, toasts su se izgubili

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(@id, 'basic-')]"));
        List<WebElement> tosts = driver.findElements(By.xpath("//div[contains(@id, 'basic-')]"));

        for (int i = 0; i < 4; i++) {
            buttons.get(i).click();
        }
        wait
                .withMessage("Toast did not show")
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.visibilityOfAllElements(tosts.get(0), tosts.get(1), tosts.get(2), tosts.get(3)));
        System.out.println("4 toasts are visible on the page");

        wait
                .withMessage("Toast did not disappear")
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.visibilityOfAllElements(tosts.get(0), tosts.get(1), tosts.get(2), tosts.get(3)));
        System.out.println("4 toasts are not visible on the page");

        driver.quit();

    }
}
