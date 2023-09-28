package p28_09_2023.Zadatak2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TestHelper {
    private WebDriver driver;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean elementExists (By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean elementExistsByList (By locatorList) {
        List<WebElement> list = driver.findElements(locatorList);

        if (!list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void  setDefaultImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void setImplicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
