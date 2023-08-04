package brainPop.pages;

import brainPop.utilities.ConfigurationReader;
import brainPop.utilities.Driver;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Log In']")
    public WebElement loginDropDown;


    @FindBy(xpath = "//*[.=\"I'm a grown-up\"]")
    public WebElement grownUpButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password-input']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='login_button']")
    public WebElement loginButton;

    @FindBy(xpath = "(//button[.='Allow all cookies'])[1]")
    public WebElement acceptCookies;

    @FindBy(xpath = "//span[.='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement search;

    @FindBy(xpath = "//li[@id='topic_result_144']")
    public WebElement DNA;

    @FindBy(xpath = "//a[@id='play_movie']")
    public WebElement watchMovie;

    @FindBy(xpath = "//button[@id='play']")
    public WebElement playButton;

    @FindBy(xpath = "(//span[@class='font_icon'])[2]")
    public WebElement stopButton;

    @FindBy(xpath = "//button[@id='volume']")
    public WebElement unmute;

    @FindBy(xpath = "//div[.='Vocabulary']")
    public WebElement vocabularyIsDisplayed;

    @FindBy(xpath = "//button[@id='caption']")
    public WebElement captionsOn;

    @FindBy(xpath = "//div[.='Related Reading']")
    public WebElement featureDNA;

//    @FindBy(xpath = "//input[@data-seek='375.2627450980392']")
//    public WebElement endVideo;


    public void loginMethod() {

        loginDropDown.click();
        grownUpButton.click();

        this.username.sendKeys(ConfigurationReader.getProperty("username"));
        this.password.sendKeys(ConfigurationReader.getProperty("password"));

        acceptCookies.click();
        loginButton.click();


        //continueButton.click();

    }

    public String getAttributeOfCaption() {
        return captionsOn.getAttribute("class");
    }

}
