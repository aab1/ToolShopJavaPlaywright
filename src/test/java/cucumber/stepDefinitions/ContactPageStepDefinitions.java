package cucumber;

import cucumber.stepDefinitions.PlaywrightCucumberFixtures;
import io.cucumber.java.Before;
import toolShop.pageObjects.ContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactPageStepDefinitions {
    ContactPage contactPage;

    @Before
    public void setUpPageObjects() {
        contactPage = new ContactPage(PlaywrightCucumberFixtures.getPage());
    }

    @Given("user navigates to the contact page")
    public void user_navigates_to_the_contact_page() {
        contactPage.openContactPage();
    }

    @Then("the contact page is displayed")
    public void the_contact_page_is_displayed() {
        assertThat(contactPage.getHeadingText())
                .isEqualTo("Contact");
    }
}
