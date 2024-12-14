package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By HeaderPageLocator = By.cssSelector("div[class='PZPZlf ssJ7i xgAzOe']");
    private final By ResultsOptionLocator = By.cssSelector("h3[class='LC20lb MBeuO DKV0Md']");
    private final By MorePlacesLocator = By.cssSelector("span[class='Z4Cazf OSrXXb']");


    public List<String> extractDataFromElements() {
        List<String> results = new ArrayList<>();
        List<WebElement> divElements = driver.findElements(ResultsOptionLocator);

        for (WebElement divElement : divElements) {
            results.add(divElement.getText());
        }
        return results;
    }
   public String GetTextOfHeader(){
        return getText(HeaderPageLocator);
   }

   public void clickOnMorePlacesLink(){
        Click(MorePlacesLocator);
   }
}
