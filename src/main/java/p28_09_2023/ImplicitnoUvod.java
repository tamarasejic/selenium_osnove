package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ImplicitnoUvod {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://demoqa.com/dynamic-properties");
        driver.findElement(By.id("visibleAfter")).click();

        List<WebElement> lista1 = driver.findElements(By.id("visibleAfter")); // 5
        List<WebElement> lista2 = driver.findElements(By.id("visibleAfter")); // 5ImplicitnoUvod
    }
}
