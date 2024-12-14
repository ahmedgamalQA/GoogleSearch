package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MorePage extends BasePage{
    public MorePage(WebDriver driver) {
        super(driver);
    }
    private final By RatingLocator = By.xpath("//span[text()='Rating']");
    private By RateOptionLocator ;
    private final By ItemRateLocator = By.xpath("//span[@class='Y0A0hc']//span[@class='yi40Hd YrbPuc']");


    public void FilterByRatingOptions(String Rate){
        RateOptionLocator = By.xpath(String.format("//span[@class='NdWbqe Y0A0hc']//span[text()='%s']", Rate));
        Click(RatingLocator);
        Click(RateOptionLocator);
    }
    public List<String> extractRateFromItems() {
        List<String> results = new ArrayList<>();
        List<WebElement> divElements = driver.findElements(ItemRateLocator);

        for (WebElement divElement : divElements) {
            results.add(divElement.getText());
        }
        return results;
    }

}
