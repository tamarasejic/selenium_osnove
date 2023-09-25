package p_25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

//        4. Zadatak
//        Napisati program koji:
//        Maksimizuje stranicu
//        Ucitava stranicu https://demoqa.com/webtables
//        Vrsi klik na edit dugme prvog reda
//        Unosi informacije za sva polja u edit formi
//        Klik na submit
//        Ceka par sekundi
//        Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.xpath("//*[@id='edit-record-1']"))
                .click();

        driver.findElement(By.xpath("//*[@id='firstName']"))
                        .clear();
        driver.findElement(By.xpath("//*[@id='firstName']"))
                .sendKeys("Marko");

        driver.findElement(By.xpath("//*[@id='lastName']"))
                        .clear();
        driver.findElement(By.xpath("//*[@id='lastName']"))
                .sendKeys("Markovic");

        driver.findElement(By.xpath("//*[@id='userEmail']"))
                        .clear();
        driver.findElement(By.xpath("//*[@id='userEmail']"))
                .sendKeys("marko@gmail.com");

        driver.findElement(By.xpath("//*[@id='age']"))
                        .clear();
        driver.findElement(By.xpath("//*[@id='age']"))
                .sendKeys("25");

        driver.findElement(By.xpath("//*[@id='salary']"))
                        .clear();
        driver.findElement(By.xpath("//*[@id='salary']"))
                .sendKeys("100000");

        driver.findElement(By.xpath("//*[@id='department']"))
                        .clear();
        driver.findElement(By.xpath("//*[@id='department']"))
                .sendKeys("Insurance");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='submit']"))
                .click();

        Thread.sleep(3000);

        driver.quit();

    }
}
