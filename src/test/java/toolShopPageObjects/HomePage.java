package toolShop.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage extends BasePage{

//    private final Page page;

    private final Locator homeNav;
    private final Locator contactNav;
    private final Locator categoriesNav;

    public HomePage(Page page) {
        super(page);

        this.homeNav = page.locator("[data-test='nav-home']");
        this.contactNav = page.locator("[data-test='nav-contact']");
        this.categoriesNav = page.locator("[data-test='nav-categories']");
    }

    @Step("Open home page")
    public void clickHome() {
        capture( "Open home page-" + System.currentTimeMillis());
        homeNav.click();
    }

    @Step("Open category: {category}")
    public void selectCategory(String category) {
        capture( "category-" + System.currentTimeMillis());
        categoriesNav.click();

        page.locator("[data-test='nav-" + category + "']")
                .click();
    }

    @Step("Open contact page")
    public void clickContact() {
        capture( "open contactPage-" + System.currentTimeMillis());
        contactNav.click();
    }

    @Step("Get home page title")
    public String getPageTitle() {
        capture( "home Page title-" + System.currentTimeMillis());
        return page.title();
    }

    public Locator getHomeNav() {
        capture( "home nav-" + System.currentTimeMillis());
        return homeNav;
    }

    public void openHOmePage() {
        page.navigate("https://practicesoftwaretesting.com");
        homeNav.waitFor();
    }
}