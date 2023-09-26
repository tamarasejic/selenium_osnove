package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) {

//        6. Ucitati stranicu https://google.com
//        Maksimizovati prozor
//        Prostavite dimenzije prozora na 700px i visinu na 700px
//
//
//        6.1. Zadatak (za vezbanje)
//        Ucitati stranicu https://cms.demo.katalon.com/
//        Maksimizovati prozor
//        Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//        Prostavite duzinu prozora na 700px i visinu na 700px
//        Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        int width = 700;
        int height = 700;

        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);

        driver.quit();
    }
}
