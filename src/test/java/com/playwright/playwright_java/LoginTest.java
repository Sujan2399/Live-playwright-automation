package com.playwright.playwright_java;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Baseclass {

    @Test
    public void testLogin() {

        Pageobject loginPage = new Pageobject(page);

        loginPage.open();
        loginPage.enterMobileNumber("9360849909");

        loginPage.enterPasswordAndSignIn("ssp@1234");
        Assert.assertEquals(loginPage.getErrorMessage(), "Password is invalid");

        loginPage.enterPasswordAndSignIn("ssp@123");
        Assert.assertTrue(page.title().contains("Dashboard"));
    }
}
