package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        2. Zadatak
//        Napisati program koji testira infinity scroll.
//        Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//        Selektujte delay od 2000ms, koristeci Select klasu.
//        Skrol do Show more dugmeta koje se nalazi na dnu stranice
//        Sacekajte da dugme bude klikljivo
//        Klik na Show more dugme
//        Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//        Sacekajte da dugme vise ne bude klikljivo
//
//        2. Zadatak (ZA VEZBANJE)
//        Modifikovati zadatak 1 tako da se skrol vrsi u vise iteracija, npr u 5


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        new Select (driver.findElement(By.id("delay-select")))
                .selectByValue("2000");

        WebElement footer = driver.findElement(By.cssSelector("div.footer"));
        WebElement scrollBtn = driver.findElement(By.cssSelector("button#infinite-scroll-button"));

        Actions actions =  new Actions(driver);
        for (int i = 0; i < 5; i++) {
            List<WebElement> currentItems = driver.findElements(By.cssSelector("div.item"));
            actions
                    .scrollToElement(footer)
                    .sendKeys(Keys.PAGE_UP) // scroll button won't load if the program jump scrolls directly to it.
                    .scrollToElement(scrollBtn)
                    .perform();
            wait
                    .withMessage("Scroll button is not clickable.")
                    .until(ExpectedConditions.elementToBeClickable(scrollBtn));

            scrollBtn.click();

            int loadedItems = currentItems.size() + 3;
            wait
                    .withMessage(loadedItems + " more elements did not load.")
                    .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.item"), loadedItems));
            wait
                    .withMessage("Scroll button is not disabled.")
                    .until(ExpectedConditions.attributeToBeNotEmpty(scrollBtn, "disabled"));
        }


        driver.quit();
    }
}
