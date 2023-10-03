package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws IOException {

//        1. Zadatak
//        Napisati program koji:
//        Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//        U folder skinite i postavite proizvoljnu sliku
//        Ucitava stranu https://tus.io/demo.html
//        Skrola do dela za upload fajla
//        Aploadujte sliku
//        Cekajte da se pojava dugme za download fajla
//
//        1.1. DOPUNA ZA VEZBANJE
//        Dopuniti prvi zadatak tako da se skine uploadovan fajl i proveri da li je size skinutog i fajla sa sistema isti.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://tus.io/demo.html");

        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("P0-0")))
                .perform();

        driver.findElement(By.id("P0-0"))
                .sendKeys(new File("test_data/witcher.png").getAbsolutePath());

        wait
                .withMessage("Download button did not show")
                .withTimeout(Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._buttons_gq6c0_28 > a")));

        driver.findElement(By.cssSelector("div._buttons_gq6c0_28 > a"))
                .click();

        String urlDL = driver.findElement(By.cssSelector("div._buttons_gq6c0_28 > a"))
                .getAttribute("href");
        String fileDL = new File("downloads/witcherDL.png").getAbsolutePath();

        try {
            JavaDownloadFileFromURL.downloadUsingNIO(urlDL, fileDL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileUL = new File("test_data/witcher.png").getAbsolutePath();
        Path pathUL = Paths.get(fileDL);
        long sizeUL = Files.size(pathUL);

        Path pathDL = Paths.get(fileDL);
        long sizeDL = Files.size(pathDL);

        if (sizeUL == sizeDL) {
            System.out.println("Downloaded file size equals original uploaded file size.");
        } else {
            System.out.println("Downloaded file size and original uploaded file size are not the same.");
        }

        driver.quit();
    }
}
