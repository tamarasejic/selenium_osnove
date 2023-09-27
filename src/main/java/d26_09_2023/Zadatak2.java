package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        2.Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//        Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//        POMOC: Brisite elemente odozdo.
//        (ZA VEZBANJE) Probajte da resite da se elemementi brisu i odozgo

//        canceling list elements from the bottom - program

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

            WebElement oldLastAlert = alertsClass.get(0);
            if (alerts.size() > 1) {
                oldLastAlert = alertsClass.get(alertsClass.size()-2);
            } else {
                oldLastAlert = alertsClass.get(alertsClass.size()-1);
            }

            String oldLastClass = oldLastAlert.getAttribute("class");

            Thread.sleep(1000);

            if (alerts.size() == n - i || !alerts.isEmpty()) {
                alerts.get(alerts.size() - 1).click();
                Thread.sleep(1000);
            }
            alerts= driver.findElements(By.cssSelector("div.alert-dismissable .close"));
            alertsClass = driver.findElements(By.cssSelector("div.alert-dismissable"));

            if (alerts.size() > 0) {
                WebElement lastAlertNew = alertsClass.get(alertsClass.size()-1);
                String newLastClass = lastAlertNew.getAttribute("class");

                if (alerts.size() == n - i - 1 && newLastClass.equals(oldLastClass)) {
                    System.out.println("Last alert message is closed successfully.");
                }
            } else {
                System.out.println("Last alert message is closed successfully.");
            }
        }

        driver.quit();
    }
}
