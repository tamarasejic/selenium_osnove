package d03_10_2023;
//        1.Zadatak
//        Kreirati BootstrapTableTests klasu koja ima:
//        Base url: https://s.bootsnipp.com/iframe/K5yrx
//        Test #1: Edit Row
//        Podaci:
//        First Name: ime polaznika
//        Last Name: prezime polaznika
//        Middle Name: srednje ime polanzika
//        Koraci:
//        Ucitati stranu /iframe/K5yrx
//        Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//        Klik na Edit dugme prvog reda
//        Sacekati da dijalog za Editovanje bude vidljiv
//        Popuniti formu podacima.
//        Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//        Klik na Update dugme
//        Sacekati da dijalog za Editovanje postane nevidljiv
//        Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//        Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//        Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//        Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//        Test #2: Delete Row
//        Podaci:
//        First Name: ime polaznika
//        Last Name: prezime polaznika
//        Middle Name: srednje ime polanzika
//        Koraci:
//        Ucitati stranu /iframe/K5yrx
//        Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//        Klik na Delete dugme prvog reda
//        Sacekati da dijalog za brisanje bude vidljiv
//        Klik na Delete dugme iz dijaloga
//        Sacekati da dijalog za Editovanje postane nevidljiv
//        Verifikovati da je broj redova u tabeli za jedan manji
//        Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//        Test #3: Take a Screenshot
//        Koraci:
//        Ucitati stranu  /iframe/K5yrx
//        Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//        Kreirati screenshot stranice.
//        Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import p02_10_2023.Helper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethodLoadPage () {
        driver.get(baseUrl);
        wait
                .withMessage("Page title is not 'Table with Edit and Update Data - Bootsnipp.com' ")
                .until(ExpectedConditions.titleIs("Table with Edit and Update Data - Bootsnipp.com"));
    }

    @Test
    public void editRow() throws InterruptedException {
        String firstName = "Marko";
        String lastName = "Markovic";
        String middleName = "Stefan";

        List<WebElement> tableRowsStart = driver.findElements(By.cssSelector("tbody > tr"));

        driver.findElement(By.cssSelector("#d1 button.update"))
                .click();

        wait
                .withMessage("Update dialog did not show after click on Edit button.")
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#edit .modal-dialog")));

        driver.findElement(By.id("fn"))
                .clear();
        driver.findElement(By.id("fn"))
                .sendKeys(firstName);

        driver.findElement(By.id("ln"))
                .clear();
        driver.findElement(By.id("ln"))
                .sendKeys(lastName);

        driver.findElement(By.id("mn"))
                .clear();
        driver.findElement(By.id("mn"))
                .sendKeys(middleName);

        driver.findElement(By.id("up"))
                .click();

        wait
                .withMessage("Update dialog did not close after click on Update button.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#edit .modal-content")));

        Assert.assertEquals(driver
                        .findElement(By.cssSelector("td#f1"))
                        .getText(),
                        firstName,
                        "First name should be " + firstName);

        Assert.assertEquals(driver
                        .findElement(By.cssSelector("td#l1"))
                        .getText(),
                        lastName,
                        "Last name should be " + lastName);

        Assert.assertEquals(driver
                        .findElement(By.cssSelector("td#m1"))
                        .getText(),
                        middleName,
                        "Middle name should be " + middleName);
    }

    @Test
    public void deleteRow() {
        String firstName = "Marko";
        String lastName = "Markovic";
        String middleName = "Stefan";

        List<WebElement> tableRowsStart = driver.findElements(By.cssSelector("tbody > tr"));

        int visibleRowsStart = 0;
        for (int i = 0; i < tableRowsStart.size(); i++) {
            if (tableRowsStart.get(i).isDisplayed()) {
                visibleRowsStart++;
            }
        }

        driver.findElement(By.cssSelector("#d1 button.delete"))
                .click();
        wait
                .withMessage("Delete dialog did not show after click on Delete button.")
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#delete .modal-content")));

        driver.findElement(By.cssSelector("button#del"))
                .click();
        wait
                .withMessage("Delete dialog did not close after click on Delete button.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#delete .modal-content")));

        List<WebElement> tableRowsNew = driver.findElements(By.cssSelector("tbody > tr")); //number of rows present in the code is the same after delete action but visibility changed

        Assert.assertTrue(!tableRowsNew.get(0).isDisplayed(),
                "Deleted row is still visible after click on delete button.");

        int visibleRowsNew = 0;
        for (int i = 0; i < tableRowsNew.size(); i++) {
            if (tableRowsNew.get(i).isDisplayed()) {
                visibleRowsNew++;
            }
        }

        Assert.assertEquals(
                visibleRowsNew,
                visibleRowsStart - 1,
                "Number of visible rows did not change after click on delete button.");
    }

    @Test
    public void takeAScreenshot() throws IOException {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String strDate = dateFormat.format(date);
        String filePath = "screenshots/screenshot-" + strDate + ".jpg";

        Helper.takeScreenshot(driver, filePath);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
