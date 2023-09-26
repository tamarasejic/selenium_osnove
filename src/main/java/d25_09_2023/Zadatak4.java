package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

//        4. Zadatak
//        Maksimizirati prozor
//        Ucitati stranicu https://artplayer.org/
//        U fokusu je player sa desne strane
//        Ceka 3-4s
//        Klik na play dugme
//        Klik na na zvucnik za mute
//        Ceka 3s
//        Klik na screenshot
//        Klik na PIP mode
//        Ceka 1s
//        Klik na Exit PIP mode
//        Klik na WebFullscreen
//        Klik na Exit WebFullscreen
//        Cekanje od 5s
//        Zatvorite pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://artplayer.org/");

        Thread.sleep(4000);

        driver.findElement(By.cssSelector("div.art-control-playAndPause i.art-icon-play path"))
                .click();

        driver.findElement(By.cssSelector("div.art-control-volume i.art-icon-volume path"))
                .click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".art-icon-screenshot path"))
                .click();

        driver.findElement(By.cssSelector(".art-icon-pip"))
                .click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".art-icon-pip"))
                .click();

        driver.findElement(By.cssSelector("i.art-icon-fullscreenWebOn"))
                .click();

        driver.findElement(By.cssSelector("i.art-icon-fullscreenWebOff"))
                .click();

        Thread.sleep(5000);

        driver.quit();
    }
}
