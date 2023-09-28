package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//        1.Zadatak
//        Ucitati stranicu https://demoqa.com/modal-dialogs
//        Kliknuti na dugme Large modal
//        Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/modal-dialogs");

       driver.findElement(By.id("showLargeModal")).click();

       boolean windowExists = true;

        try {
            driver.findElement(By.cssSelector(".modal-content"));
            System.out.println("Window is opened");
        } catch (Exception n) {
            windowExists = false;
            System.out.println("Window is not opened");
        }


        driver.quit();
    }
}
