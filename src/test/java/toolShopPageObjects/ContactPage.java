package toolShopPageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.ScreenshotManager;
import io.qameta.allure.Step;

public class ContactPage extends BasePage {

    private final  Locator pageHeading;

    public ContactPage(Page page) {
        super(page);
        this.pageHeading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contact"));
    }

    @Step("Get Contact Page Heading")
    public String getHeadingText() {
        capture( "ContactPage-" + System.currentTimeMillis());
        return pageHeading.innerText();
    }

    public Locator getPageHeading() {
        capture( "get locator for contact Page Heading-" + System.currentTimeMillis());
        return pageHeading;
    }

    @Step("Get page title")
    public String getPageTitle() {
        capture( "Contact Page Title-" + System.currentTimeMillis());
        return page.title();
    }

    public void openContactPage() {
        page.navigate("https://practicesoftwaretesting.com/contact");
        pageHeading.waitFor();
    }

}
