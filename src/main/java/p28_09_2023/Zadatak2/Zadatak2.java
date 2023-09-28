package p28_09_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) {

//        2. Zadatak
//        Ucitati stranicu https://demoqa.com/modal-dialogs
//        Kliknuti na dugme Large modal
//        Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke
//        Kreirati klasu TestHelper koja ima:
//        privatan atribut driver
//        kontukstor sa parametrom
//        metodu elementExists koja vraca true ili false ako element postoji.
//        Metoda kao parametar prima nacin trazenja By objekat. Metoda radi proveru preko TryCatch-a
//        metodu elementExistsByList koja takodje vraca true ili false. Metoda kao parametar prima By objekat za trazenje.
//        metodu setDefaultImplicitWait koja postavlja implicino cekanje na 10s.
//        metodu setImplicitWait koja postavlja implicitno cekanje iz prosledjene vrednosti.
//
//        U glavnom programu resiti prvi zadatak koriseci objekat klase TestHelper za proveru elemenata i za postavljanje implicitnog cekanja.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/modal-dialogs");

        driver.findElement(By.id("showLargeModal")).click();
        By x = By.id("showLargeModal");

        TestHelper helper1 = new TestHelper(driver);

        helper1.setDefaultImplicitWait();
        helper1.setImplicitWait(5);

        boolean x1 = helper1.elementExists(x);
        boolean x2 = helper1.elementExistsByList(x);


        if (x1) {
            System.out.println("Element exists");
        } else {
            System.out.println("Element does not exist.");
        }

        if (x2) {
            System.out.println("Element exists");
        } else {
            System.out.println("Element does not exist.");
        }

        driver.quit();
    }
}
