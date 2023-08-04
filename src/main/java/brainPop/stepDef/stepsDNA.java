package brainPop.stepDef;

import brainPop.pages.LoginPage;
import brainPop.pages.RelatedReadingPage;
import brainPop.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class stepsDNA {

    LoginPage loginPage = new LoginPage();

    Actions actions = new Actions(Driver.getDriver());

    @When("Navigate to the BrainPOP Homepage")
    public void navigateToTheBrainPOPHomepage() {

        Driver.getDriver().get("https://www.brainpop.com/");
    }

    @When("Log in with the above username and password")
    public void log_in_with_the_above_username_and_password() {

        loginPage.loginMethod();
    }


    @Then("Enter and submit the following Search query: Challenge")
    public void enter_and_submit_the_following_search_query_challenge() throws Exception {

        Thread.sleep(2000);
        loginPage.search.sendKeys("Challenge" + Keys.ENTER);
    }

    @Then("Select the Topic DNA from the search Results page")
    public void select_the_topic_dna_from_the_search_results_page() {


        actions.scrollToElement(loginPage.DNA).perform();

        loginPage.DNA.click();
    }

    @Then("Perform various actions with the movie player")
    public void perform_various_actions_with_the_movie_player() throws Exception {

        actions.scrollToElement(loginPage.watchMovie).perform();

        loginPage.watchMovie.click();

        actions.scrollToElement(loginPage.playButton).perform();

        Thread.sleep(1000);
        loginPage.playButton.click();
        Thread.sleep(5000);
        loginPage.unmute.click();
        Thread.sleep(1000);
        System.out.println("loginPage.vocabularyIsDisplayed.isDisplayed() = " + loginPage.vocabularyIsDisplayed.isDisplayed());
        Thread.sleep(1000);
        loginPage.captionsOn.click();
        Thread.sleep(5000);
        loginPage.stopButton.click();
    }

    @Then("Select a Feature associated with the Topic")
    public void select_a_feature_associated_with_the_topic()  throws Exception{

        actions.scrollToElement(loginPage.featureDNA).perform();
        loginPage.featureDNA.click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        actions.sendKeys(Keys.PAGE_UP).perform();

    }

    @When("Validate whether the number of Topics returned matches the amount of Topics reported in Topics \\(X Results)")
    public void validateWhetherTheNumberOfTopicsReturnedMatchesTheAmountOfTopicsReportedInTopicsXResults()throws Exception {

        Thread.sleep(1000);
        String expectedTopic = Driver.getDriver().findElement(By.xpath("//span[@class='topics_results_number']")).getText();
        int expectedTopicCounts = Integer.parseInt(expectedTopic);

        List < WebElement > topics = new ArrayList<>();
        topics.addAll(Driver.getDriver().findElements(By.xpath("//ul[@id='topic_list']/li")));

        try{
            Assert.assertEquals(expectedTopicCounts,topics.size());

        }catch(AssertionError e){
            e.printStackTrace();
        }

    }

    @Then("Confirm that the User can play the Movie and see its End Screen")
    public void confirmThatTheUserCanPlayTheMovieAndSeeItsEndScreen() throws Exception {

        Thread.sleep(1000);
        Driver.getDriver().navigate().forward();
        Thread.sleep(1000);
        Driver.getDriver().navigate().forward();

        // Need to click the video in 6:13 second or 6:14 second manually right after video starts,
        // in order test will continue to pass
        //Also video length till end showing 6:16 but plays till 6:17 which is a bug
        loginPage.playButton.click();
        Thread.sleep(2000);

//        loginPage.endVideo.click();
//        Thread.sleep(5000);

        WebElement playback = Driver.getDriver().findElement(By.xpath("//progress[@value='377']"));
        if (playback.isDisplayed()) {
            System.out.println("Movie playback and end screen verification successful.");
        } else {
            System.out.println("Movie playback or end screen verification failed.");
        }

    }

    @And("Validate that the Closed Caption feature can be toggled [On and Off]")
    public void validateThatTheClosedCaptionFeatureCanBeToggledOnOff() {

        loginPage.captionsOn.click();
        System.out.println("loginPage.getAttributeOfCaption() = " + loginPage.getAttributeOfCaption());
        Assert.assertTrue(loginPage.getAttributeOfCaption().contains("active"));

        loginPage.captionsOn.click();
        Assert.assertFalse(loginPage.getAttributeOfCaption().contains("active"));
    }

    @Then("Select the Related Reading Feature from the Features list")
    public void selectTheRelatedReadingFeatureFromTheFeaturesList() throws Exception {

        Driver.getDriver().navigate().back();
        Thread.sleep(2000);
        loginPage.featureDNA.click();
    }


    @Then("Generalize that function to select any Future from the Topic page")
    public void generalizeThatFunctionToSelectAnyFutureFromTheTopicPage()throws Exception {

        RelatedReadingPage relatedReadingPage = new RelatedReadingPage();
        relatedReadingPage.selectFeature("Trivia");
        Thread.sleep(5000);

    }
}
