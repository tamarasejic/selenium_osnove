package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UrlPage extends BasicPage{

    public UrlPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForCurrentPageToBeInventoryPage(){
        wait
                .withMessage("Successful login did not redirect to page https://www.saucedemo.com/inventory.html")
                .until(ExpectedConditions.urlContains("/inventory.html"));
    }

}
