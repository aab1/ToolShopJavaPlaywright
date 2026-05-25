package tests;

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
import toolShop.pageObjects.ContactPage;
import toolShop.pageObjects.HomePage;

@DisplayName("Contact page test")
@Feature("Contact page")
@UsePlaywright(HeadlessChromeOptions.class)
public class ValidateContactPageTest {
    ContactPage contactPage;

    @BeforeEach
    void openContactPage(Page page) {
        page.navigate("https://practicesoftwaretesting.com/contact");

        contactPage = new ContactPage(page);

        com.microsoft.playwright.assertions.PlaywrightAssertions
                .assertThat(contactPage.getPageHeading())
                .isVisible();
    }


    @Test
    @Story("Contact page test 1")
    @DisplayName("Verify contact page title")
    void shouldHaveTheCorrectTitle() {
        Assertions.assertTrue(
                contactPage.getPageTitle()
                        .contains("Contact Us - Practice Software Testing - Toolshop")
        );
    }

}
