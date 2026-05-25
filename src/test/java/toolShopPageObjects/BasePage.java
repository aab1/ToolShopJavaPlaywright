package toolShopPageObjects;

import com.microsoft.playwright.Page;
import config.ScreenshotManager;

public abstract class BasePage {

    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

    protected void capture(String name) {
        ScreenshotManager.takeScreenshot(page, name);
    }
}
