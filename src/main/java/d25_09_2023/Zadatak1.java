package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        1. Zadatak
//        Maksimizirati prozor
//        Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//        Prijavite se na sistem
//        Username: Admin
//        Password: admin123
//        Cekanje od 5s
//        U input za pretragu iz navigacije unesite tekst Me
//        Kliknite na prvi rezultat pretrage (to ce biti Time)
//        Cekanje od 1s
//        Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//        Klinkite na logout
//        Cekanje od 5s
//        Zatvorite pretrazivac

        String username = "Admin";
        String password = "admin123";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input[name='username']"))
                        .clear();
        driver.findElement(By.cssSelector("input[name='username']"))
                        .sendKeys(username);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name='password']"))
                        .clear();
        driver.findElement(By.cssSelector("input[name='password']"))
                .sendKeys(password);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']"))
                        .click();

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("div.oxd-main-menu-search > input"))
                        .clear();
        driver.findElement(By.cssSelector("div.oxd-main-menu-search > input"))
                .sendKeys("Me");

        driver.findElement(By.cssSelector(".oxd-sidepanel-body > ul > li > a"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("span.oxd-userdropdown-tab"))
                .click();

        driver.findElement(By.cssSelector("ul.oxd-dropdown-menu > li:nth-child(4) > a"))
                .click();

        Thread.sleep(5000);

        driver.quit();
    }
}
