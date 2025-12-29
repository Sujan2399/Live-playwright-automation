package com.playwright.playwright_java;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

public class LoginTest {

    Playwright playwright;
    Browser browser;
    Page page;
    DashboardMySchool dashboard;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();

        dashboard = new DashboardMySchool(page);
    }

    @Test(priority = 1)
    public void loginFlowTest() {
        page.navigate("https://smartschoolnxt.co.in/");
        page.waitForTimeout(2000);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
        page.waitForTimeout(2000);

        assertThat(page.getByText("Enter valid Mobile Number")).isVisible();
        page.waitForTimeout(2000);

        Locator mobileInput = page.getByPlaceholder(" Registered mobile number");
        Locator passwordInput = page.getByPlaceholder("Enter your password");

        mobileInput.fill("5666666666666");
        page.waitForTimeout(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
        page.waitForTimeout(2000);
        assertThat(page.getByText("Mobile number is invalid")).isVisible();
        page.waitForTimeout(2000);

        mobileInput.fill("9876543210");
        page.waitForTimeout(2000);
        passwordInput.fill("fdgbdfgdfg");
        page.waitForTimeout(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Sign In")).click();
        page.waitForTimeout(2000);
        assertThat(page.getByText(Pattern.compile("Password .* invalid"))).isVisible();
        page.waitForTimeout(2000);

        passwordInput.fill("ssp@123");
        page.waitForTimeout(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Sign In")).click();
        page.waitForTimeout(2000);

        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard"))).isVisible();
        page.waitForTimeout(2000);
    }

    @Test(priority = 2, dependsOnMethods = {"loginFlowTest"})
    public void dashboardAndProfileTest() {
        dashboard.goToDashboard();
        dashboard.selectSchool("Demo SCHOOL");
        dashboard.goToProfile();
        dashboard.goToYearSection();
        dashboard.updateAcademicYear("2029");
    }

    @AfterClass
    public void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
