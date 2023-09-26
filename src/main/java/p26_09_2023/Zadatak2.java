package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        2.Zadatak
//        Napisti program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//        Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//        Ceka 1s
//        Hvata sve elemente prvog reda i stampa tekst svakog elementa
//        Ceka 5s
//        Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

//        List<WebElement> table = driver.findElements(By.cssSelector("div.left_bar  li.nav-item"));
//        WebElement firstTable = table.get(1);

        Thread.sleep(1000);
        List<WebElement> firstColumn = driver.findElements(By.cssSelector("div#lorem tbody > tr > td:nth-child(1)"));

        for (int i = 0; i < firstColumn.size(); i++) {
            Thread.sleep(2000);
            System.out.println(firstColumn.get(i).getText());
        }

        List<WebElement> firstRow = driver.findElements(By.cssSelector("div#lorem tbody > tr:first-child > td"));

        for (int i = 0; i < firstRow.size(); i++) {
            Thread.sleep(2000);
            System.out.println(firstRow.get(i).getText());
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
