package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        1. Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://demoqa.com/automation-practice-form
//        Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
//        (za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
//        Klik na submit

        Scanner s = new Scanner(System.in);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(1000);
        System.out.print("Enter first name: ");
        driver.findElement(By.id("firstName")).sendKeys(s.next());

        System.out.print("Enter last name: ");
        driver.findElement(By.id("lastName")).sendKeys(s.next());

        System.out.print("Enter user email: ");
        driver.findElement(By.id("userEmail")).sendKeys(s.next());

        System.out.print("Enter gender (Male, Female, Other): ");
        String gender = s.next();

        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(By.cssSelector("label[for='gender-radio-2']")).click();
        } else {
            driver.findElement(By.cssSelector("label[for='gender-radio-3']")).click();
        }

        System.out.print("Enter Mobile(10 Digits): ");
        driver.findElement(By.id("userNumber")).sendKeys(s.next());

        System.out.print("Enter month of Birth: ");
        String month = s.next();
        System.out.print("Enter day of Birth: ");
        String day = s.next();
        System.out.print("Enter year of Birth: ");
        String year = s.next();

        Actions actions = new Actions(driver);
        WebElement dateExisting = driver.findElement(By.id("dateOfBirthInput"));

// perform select all (ctrl+a) pressing action because clearing the existing date in the input box crushes the page
        actions.keyDown(dateExisting,Keys.CONTROL).sendKeys(dateExisting,"A").keyUp(dateExisting,Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(month + " " + day + " " + year);
        driver.findElement(By.tagName("body")).click();

        Thread.sleep(1000);

        System.out.println("Enter Subject names and/or END to cancel: ");
        boolean end = false;
            while (!end) {
                System.out.print("Enter subject: ");
                String subject = s.next();
                if (!subject.equalsIgnoreCase("end")) {
                    driver.findElement(By.id("subjectsInput")).sendKeys(subject);
                    driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
                } else {
                    end = true;
                }
            }

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"))
                .click();

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"))
                .click();

        driver.findElement(By.id("uploadPicture")).sendKeys("D:\\ITBOOTCAMP\\10. Nedelja\\31. predavanje 25.09. ponedeljak\\artplayer_00_03.png");

        driver.findElement(By.id("currentAddress")).sendKeys("Ulica i broj 123/1");
        driver.findElement(By.tagName("body")).click();

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);

//        ad pop up blocks remaining functions - code to be continued after next lesson

        Thread.sleep(5000);
        driver.quit();
    }
}
