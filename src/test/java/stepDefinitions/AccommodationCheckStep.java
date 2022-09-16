package stepDefinitions;

import com.pages.Accommodation;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccommodationCheckStep {
    private static String title;
    private final Accommodation accommodation  = new Accommodation(DriverFactory.getDriver());
    @Given("User is on POI page")
    public void userIsOnPOIPage() {
       DriverFactory.getDriver().get("https://poi.targomo.com/");
    }

    @When("Page title is  {string}")
    public void pageTitleIs(String pageTitle) {
        String title = accommodation.getPageTitle();
//        Assert.assertTrue(title.contains(pageTitle));
        System.out.println("title is: "+ title);
        System.out.println(pageTitle);
    }


    @When("user clicks the Accommodation Button")
    public void userClicksTheAccommodationButton() {
//        System.out.println("Clicking the Accommodation");
        accommodation.clickOnAccommodation();

    }

    @Then("Accommodation Button Should be Selected")
    public void accommodationButtonShouldBeSelected() {
        Assert.assertTrue(accommodation.isAccommodationCheckBoxSelected());
    }



}
