package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Zadatak6ZaVezbanje {
    public static void main(String[] args) throws IOException {

//        6.  Zadatak (za vezbanje)
//        Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u folderu screenshots po imenom screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
//        Koristan link https://www.javatpoint.com/java-date-to-string
//        4. Zadatak Napisati program koji:
//        Kreirati screenshots folder u projektu
//        Ucitava stranicu https://google.com
//        Kreira screenshot stranice
//        Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//        Koristan link 1. LAKSE CE VAM BITI PREKO OVOG
//        Koristan link 2
//        Koristan link 3

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://google.com");

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String strDate = dateFormat.format(date);
        String filePath = "screenshots/screenshot-" + strDate + ".jpg";

        Helper.takeScreenshot(driver, filePath);

        driver.quit();
    }
}
