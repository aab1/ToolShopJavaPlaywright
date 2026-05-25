package testsFiles;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.LoadState;
import config.HeadlessChromeOptions;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import toolShopPageObjects.ContactPage;
import toolShopPageObjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("Home page test")
@Feature("Home page")
@UsePlaywright(HeadlessChromeOptions.class)
public class ValidateHomePageTest {

    HomePage homePage;
    ContactPage contactPage;

    @BeforeEach
    void openHomePage(Page page) {
        page.navigate("https://practicesoftwaretesting.com");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        homePage = new HomePage(page);
        contactPage = new ContactPage(page);
    }


    @Test
    @Story("Home page test 1")
    @DisplayName("Verify home page title")
    void shouldHaveTheCorrectTitle() {
        Assertions.assertTrue(
                homePage.getPageTitle()
                        .contains("Practice Software Testing")
        );
    }

    @Test
    @Story("Home page test 2")
    @DisplayName("Verify home is visible on page")
    void shouldDisplayHomeInNav() {

        com.microsoft.playwright.assertions.PlaywrightAssertions
                .assertThat(homePage.getHomeNav())
                .containsText("Home");

        com.microsoft.playwright.assertions.PlaywrightAssertions
                .assertThat(homePage.getHomeNav())
                .matchesAriaSnapshot("- link \"Home\":\n  - /url: /");
    }

    @Test
    @Story("Home page to contact page navigation test 1")
    @DisplayName("Verify that contact page is displayed")
    void shouldNavigateToContactPage() {

        homePage.clickContact();

        assertThat(contactPage.getHeadingText())
                .isEqualTo("Contact");
    }
}