package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageLoadTimeoutUvod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        System.out.println("Pocni ucitavanje");
        driver.get("https://cms.demo.katalon.com/");

        System.out.println("Stranica ucitana.");
    }
}
