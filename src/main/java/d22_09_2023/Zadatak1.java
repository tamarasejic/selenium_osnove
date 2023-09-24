package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//    1. Zadatak
//    Napisati program koji:
//    ima niz od 5 stringova. Svaki element u nizu je url stranice:
//    https://www.google.com/
//    https://www.facebook.com/
//    https://www.youtube.com/
//    https://www.ebay.com/
//    https://www.katalon.com/
//    kreira testnu infrastukturu
//    zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu i pritom pravi pauzu od 2 sekunde izmedju svaka dva ucitanja stranice
//    Na kraju program ponisava testnu infrastukturu

        ArrayList<String> pageURLs = new ArrayList<>();
        pageURLs.add("https://www.google.com/");
        pageURLs.add("https://www.facebook.com/");
        pageURLs.add("https://www.youtube.com/");
        pageURLs.add("https://www.ebay.com/");
        pageURLs.add("https://www.katalon.com/");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        for (String url : pageURLs) {
            driver.get(url);
            Thread.sleep(2000);
        }

        driver.quit();
    }
}
