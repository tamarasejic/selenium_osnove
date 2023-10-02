package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {

//        3. Zadatak
//        Napisati program koji:
//        Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//        Implicitno cekanje za trazenje elemenata je maksimalno 10s
//        Implicitno cekanje za ucitavanje stranice je 5s
//        Ucitava stranicu https://docs.katalon.com/
//        Maksimizuje prozor
//        Od html elementa cita data-theme atribut.
//        Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//        Klikce na dugme za zamenu tema
//        Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//        Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//        Ceka da se dijalog za pretragu pojavi
//        Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//        Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://docs.katalon.com/");

        String dataTheme = driver.findElement(By.xpath("/html")).getAttribute("data-theme");
        System.out.println("Data theme is " + dataTheme);

        wait
                .withMessage("Data theme is not light.")
                .until(ExpectedConditions.attributeToBe(By.xpath("/html"), "data-theme", "light"));
        System.out.println("Data theme is light.");

         driver
                 .findElement(By.cssSelector("button.toggleButton_rCf9"))
                 .click();

        wait
                .withMessage("Data theme is not dark.")
                .until(ExpectedConditions.attributeToBe(By.xpath("/html"), "data-theme", "dark"));
        System.out.println("Data theme is dark.");

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();

        wait
                .withMessage("Search dialog did not show.")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.DocSearch-Modal")));

        wait
                .withMessage("Input type value is not search")
                .until(ExpectedConditions.attributeToBe(By.id("docsearch-input"), "type", "search"));
        System.out.println("Input type value is search.");

        driver.quit();
    }
}
