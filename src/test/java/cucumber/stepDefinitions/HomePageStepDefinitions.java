package cucumber.stepDefinitions;

import cucumber.PlaywrightCucumberFixtures;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import toolShop.pageObjects.ContactPage;
import toolShop.pageObjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepDefinitions {
    HomePage homePage;
    ContactPage contactPage;

    @Before
    public void setUpPageObjects() {
        homePage = new HomePage(PlaywrightCucumberFixtures.getPage());
        contactPage = new ContactPage(PlaywrightCucumberFixtures.getPage());
    }

    @Given("user navigates to the home page")
    public void user_navigates_to_the_home_page() {
        homePage.openHOmePage();
    }
    @When("user clicks contact nav")
    public void user_clicks_contact_nav() {
        homePage.clickContact();
    }

    @Then("home button is visible in the nav bar")
    public void homeButtonIsVisibleInTheNavBar() {
        assertThat(homePage.getHomeNav().isVisible()).isTrue();
    }
}
