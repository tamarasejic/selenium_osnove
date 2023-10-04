package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Zadatak5ZaVezbanje {
    public static void main(String[] args) {

//        5.Zadatak (za vezbanje)
//        Napisati program koji:
//        Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
//        Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
//        Ceka da se prikazu 4 item-a a upload
//        Klik na upload
//        Ceka da se upload zavrsi

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        ArrayList<File> imgFile = new ArrayList<>();
        imgFile.add(new File("test_data/front.jpg"));
        imgFile.add(new File("test_data/right.jpg"));
        imgFile.add(new File("test_data/left.jpg"));
        imgFile.add(new File("test_data/back.jpg"));

        for (int i = 0; i < imgFile.size(); i++) {
            driver
                    .findElement(By.name("files[]"))
                    .sendKeys(imgFile.get(i).getAbsolutePath());
        }

        wait
                .withMessage("Not all " + imgFile.size() + " uploaded photos are shown in the upload list.")
                .until(ExpectedConditions.numberOfElementsToBe(By.className("preview"), imgFile.size()));

        driver.findElement(By.cssSelector("[type='submit']"))
                .click();

        wait
                .withMessage("Progress bar did not reach full 100%.")
                .until(ExpectedConditions
                        .attributeToBe(By.className("progress-striped"), "aria-valuenow", "100"));

        driver.quit();
    }
}
