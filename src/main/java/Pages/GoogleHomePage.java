package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends BasePage {
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    private final By SearchFieldLocator = By.id("APjFqb");
    private final By SearchClickLocator = By.cssSelector("input[aria-label='Google Search']");

    public void SearchOnGoogle(String KeySearch1) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SearchFieldLocator))).clear();
        sendKeys(KeySearch1,SearchFieldLocator);
    }
    public void ClickOnSearchButton(){
        Click(SearchClickLocator);
    }
}