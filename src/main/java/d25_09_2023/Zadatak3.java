package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

//        3. Zadatak
//        Napisati program koji vrsi dodavanje 5 redova
//        Maksimizirati prozor
//        Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//        Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//        Klik na dugme Add New
//        Unesite name,departmant i phone (uvek iste vrednost)
//        Trazenje po name atributu
//        Kliknite na zeleno Add dugme.
//            PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
//            Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//        Cekanje od 0.5s
//        Na kraju programa ugasite pretrazivac.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        Thread.sleep(1000);

        for (int i = 0; i < 5; i++) {

            driver.findElement(By.cssSelector("button.add-new"))
                    .click();

            driver.findElement(By.cssSelector("tr:last-child input[name='name']"))
                    .clear();
            driver.findElement(By.cssSelector("tr:last-child input[name='name']"))
                    .sendKeys("Pera Peric");

            driver.findElement(By.cssSelector("tr:last-child input[name='department']"))
                    .clear();
            driver.findElement(By.cssSelector("tr:last-child input[name='department']"))
                    .sendKeys("Administration");

            driver.findElement(By.cssSelector("tr:last-child input[name='phone']"))
                    .clear();
            driver.findElement(By.cssSelector("tr:last-child input[name='phone']"))
                    .sendKeys("(381) 555-1111");

            driver.findElement(By.cssSelector("tr:last-child td:last-child a.add"))
                    .click();

            Thread.sleep(500);
        }

        driver.quit();
    }
}
