package com.playwright.playwright_java;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import org.testng.annotations.*;

public class Baseclass {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    // ✅ COMMON WAIT METHODS (ADD THESE)

    protected void waitForVisible(String locator) {
        page.waitForSelector(locator,
            new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
    }

    protected void waitForAttached(String locator) {
        page.waitForSelector(locator,
            new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.ATTACHED));
    }

    protected void waitForHidden(String locator) {
        page.waitForSelector(locator,
            new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.HIDDEN));
    }

    protected void waitForTimeout(int millis) {
        page.waitForTimeout(millis);
    }

//    @AfterMethod
//    public void tearDown() {
//        if (page != null) page.close();
//        if (browser != null) browser.close();
//        if (playwright != null) playwright.close();
    }
//}
