package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

//        5. Zadatak
//        Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//        Posto ne radi sajt, probajte funkcionalnost checkbox-a na ovom sajtu https://demoqa.com/automation-practice-form
//        Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"))
                .click();
        Thread.sleep(2000);

        WebElement checkbox = driver.findElement(By.cssSelector("input#hobbies-checkbox-1"));
        boolean isChecked = checkbox.isSelected();

        if (!isChecked) {
           checkbox.click();
        }
        Thread.sleep(1000);
        driver.quit();
    }
}
