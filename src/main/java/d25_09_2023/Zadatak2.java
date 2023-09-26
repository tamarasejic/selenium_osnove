package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        2. Zadatak
//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter. Koristan link
//        Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//        Cekanje od 5s
//        Zatvorite pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        ArrayList<String> toDos = new ArrayList<>();
        toDos.add("Visit Paris");
        toDos.add("Visit Prague");
        toDos.add("Visit London");
        toDos.add("Visit New York");
        toDos.add("Visit Belgrade");

        driver.get("https://example.cypress.io/todo");

        Thread.sleep(2000);

//        if there are existing todo elements in the list when loading the page, clear the list:

        List<WebElement> existingList = driver.findElements(By.cssSelector("ul.todo-list > li label"));

//        delete todo list button appears only when hovering over the element, need to mouse hover over todo element for it to appear

        List<WebElement> buttonX = driver.findElements(By.cssSelector("ul.todo-list > li button.destroy"));
        Actions actions = new Actions(driver);

        if (!existingList.isEmpty()) {
            for (int i = 0; i < existingList.size(); i++) {
                actions.moveToElement(existingList.get(i));
                Thread.sleep(1000);
                actions.moveToElement(buttonX.get(i));
                Thread.sleep(500);
                actions.click().build().perform();
                Thread.sleep(500);
            }
        }

        Thread.sleep(2000);

        for (int i = 0; i < toDos.size(); i++) {

            driver.findElement(By.cssSelector(".new-todo"))
                    .sendKeys(toDos.get(i));

            driver.findElement(By.cssSelector(".new-todo"))
                    .sendKeys(Keys.ENTER);

            Thread.sleep(1000);
        }

        List<WebElement> toDoList = driver.findElements(By.cssSelector("ul.todo-list > li input.toggle"));

        for (WebElement webElement : toDoList) {
            webElement.click();
            Thread.sleep(500);
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
