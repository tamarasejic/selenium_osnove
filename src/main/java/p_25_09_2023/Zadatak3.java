package p_25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

//        3. Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://demoqa.com/text-box
//        Unosi informacije za 3 osobe koristeci petlju
//        Full Name
//        Email
//        Current Address
//        Permanent Address
//        Klik na submit
//        Ceka 2 sekunde
//        Osvezava stranicu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");

        for (int i = 0; i < 3; i++) {

            driver.findElement(By.xpath("//*[@placeholder='Full Name']"))
                    .sendKeys("Marko Markovic");

            driver.findElement(By.xpath("//*[@id='userEmail']"))
                    .sendKeys("marko@gmail.com");

            driver.findElement(By.xpath("//*[@id='currentAddress']"))
                    .sendKeys("Ulica i broj 123");

            driver.findElement(By.xpath("//*[@id='permanentAddress']"))
                    .sendKeys("Ulica i broj 123/54");

            driver.findElement(By.xpath("//*[@id='submit']"))
                    .click();

            Thread.sleep(3000);

            driver.navigate().refresh();
        }

        driver.quit();
    }
}
