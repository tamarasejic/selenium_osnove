package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2_1 {
    public static void main(String[] args) throws InterruptedException {

//        2.Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//        Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//        POMOC: Brisite elemente odozdo.
//        (ZA VEZBANJE) Probajte da resite da se elemementi brisu i odozgo


//        canceling list elements from the top - program

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        Thread.sleep(1000);

        List<WebElement> alertsStart = driver.findElements(By.cssSelector("div.alert-dismissable .close"));
        int n = alertsStart.size();

        for (int i = 0; i < n; i++) {
            List<WebElement> alerts= driver.findElements(By.cssSelector("div.alert-dismissable .close"));
            List<WebElement> alertsClass = driver.findElements(By.cssSelector("div.alert-dismissable"));

            WebElement oldSecondAlert = alertsClass.get(0);
            if (alerts.size() > 1) {
                oldSecondAlert = alertsClass.get(1);
            }

            String oldSecondClass = oldSecondAlert.getAttribute("class");

            Thread.sleep(1000);

            if (alerts.size() == n - i || !alerts.isEmpty()) {
                alerts.get(0).click();
                Thread.sleep(1000);
            }
            alerts= driver.findElements(By.cssSelector("div.alert-dismissable .close"));
            alertsClass = driver.findElements(By.cssSelector("div.alert-dismissable"));

            if (!alerts.isEmpty()) {
                WebElement firstAlertNew = alertsClass.get(0);
                String newFirstClass = firstAlertNew.getAttribute("class");

                if (alerts.size() == n - i - 1 && newFirstClass.equals(oldSecondClass)) {
                    System.out.println("Last alert message is closed successfully.");
                }
            } else {
                System.out.println("Last alert message is closed successfully.");
            }
        }

        driver.quit();
    }
}
