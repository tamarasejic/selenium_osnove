package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {

//        3.Zadatak
//        Napisati program koji ucitava stranicu Zadatak4.html
//        Skinite Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a i ikopirajte url. To je url za get u programu:
//
//        I na stranici vrsi klik na Show in dugme
//        Ceka da se pojavi itbootcamp poruka koristeci explicitni wait
//
//                (za vezbanje)
//        I na stranici dodaje 5 poruka “IT Bootcamp”
//        Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//        Sacekati da se novi element pojavi pre nego sto se doda sledeci


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("file:///D:/ITBOOTCAMP/10.%20Nedelja/33.%20predavanje%2028.09.%20cetvrtak/Zadatak4.html");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement btn = driver.findElement(By.id("showInBtn"));
        btn.click();

        wait
                .withMessage("Message does not exist.")
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));

        wait
                .withMessage("Message does not say - IT Bootcamp.")
                .pollingEvery(Duration.ofMillis(200))
                    .until(ExpectedConditions.textToBe(By.id("id-0"), "IT Bootcamp"));

        driver.navigate().refresh();

        for (int i = 0; i < 5; i++) {
            btn.click();

            wait
                    .withMessage("Message does not exist.")
                    .pollingEvery(Duration.ofMillis(200))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));

            wait
                    .withMessage("Message does not say - IT Bootcamp.")
                    .pollingEvery(Duration.ofMillis(200))
                    .until(ExpectedConditions.textToBe(By.id("id-" + i), "IT Bootcamp"));

        }


        driver.quit();
    }
}
