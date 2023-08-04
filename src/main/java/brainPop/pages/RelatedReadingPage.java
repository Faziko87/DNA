package brainPop.pages;

import brainPop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RelatedReadingPage {

    public RelatedReadingPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//ul[@id='related_reading_menu_portable']/li/div[1]")
    public List<WebElement> features;

    public void selectFeature(String featureName){

        for (WebElement feature : features) {
            if(feature.getText().contains(featureName)){
                feature.click();
            }
        }
    }
}
