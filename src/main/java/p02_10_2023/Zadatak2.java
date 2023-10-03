package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {

//        2. Zadatak
//        Napisati program koji:
//        Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//        Uploadujte sliku
//        Ceka se da se pojavi slika u listi uploadovanih fajlova
//        Koristite uslov da broj elemenata bude 1.
//        Klik na Start dugme u okviru item-a koji se uploadovao
//        Ceka se da se pojavi delete dugme pored itema
//        Klik na delete dugme pored itema
//        Ceka se da se element obrise
//        Koristite da broj elemenata bude 0

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/");

        driver.findElement(By.cssSelector("[type='file']"))
                .sendKeys(new File ("test_data/witcher.png").getAbsolutePath());

        wait
                .withMessage("File not present in upload list.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("p.name"),1));

        driver.findElement(By.cssSelector("td .btn-primary"))
                .click();

        wait
                .withMessage("Delete button not present")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td .btn-danger")));

        driver.findElement(By.cssSelector("td .btn-danger"))
                .click();

        wait
                .withMessage("File present in upload list.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("p.name"),0));

        driver.quit();
    }
}
