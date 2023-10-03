package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import p02_10_2023.JavaDownloadFileFromURL;

import java.io.IOException;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {

//        3. Zadatak
//        Napisati program koji
//        Kreirati folder downloads folder u projektu
//        Ucitava stranu https://www.pexels.com/photo/a-woman-holding-a-laptop-in-the-living-room-6585859/
//        Cita href atribut sa glavne slike sa stranice
//        Koristi link iz href atributa za skidanje slike
//        Sliku sacuvajte u folderu downloads pod nazivom woman-holding-laptop.jpeg
//        Koristan link za skidanje fajlova u javi
//        Azurirajte gitignore da ignorise downloads folder

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.pexels.com/photo/a-woman-holding-a-laptop-in-the-living-room-6585859/");

        String url1 = "https://cdn.britannica.com/29/150929-050-547070A1/lion-Kenya-Masai-Mara-National-Reserve.jpg";
        String file = "downloads/ljuti-lav.jpg";

        try {
            JavaDownloadFileFromURL.downloadUsingNIO(url1, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
