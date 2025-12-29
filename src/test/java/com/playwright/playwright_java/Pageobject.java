package com.playwright.playwright_java;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Pageobject {

    private Page page;

    // Locators
    private String mobileInput = "#mobile";       
    private String passwordInput = "#password";   
    private String loginButton = "#loginBtn";     
    private String errorMsg = ".error-msg";       

    // Constructor
    public Pageobject(Page page) {
        this.page = page;
    }

    // Open the URL and wait for full load
    public void open() {
        page.navigate("https://smartschoolnxt.co.in/");
        page.waitForLoadState(LoadState.NETWORKIDLE);  // Wait until network is idle
    }

    // Enter mobile number with explicit wait
    public void enterMobileNumber(String mobile) {
        page.locator(mobileInput)
            .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
        page.fill(mobileInput, mobile);
    }

    // Enter password and click login safely
    public void enterPasswordAndSignIn(String password) {
        page.locator(passwordInput)
            .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
        page.fill(passwordInput, password);

        page.locator(loginButton)
            .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
        page.click(loginButton);
    }

    // Get error message if present
    public String getErrorMessage() {
        Locator errorLocator = page.locator(errorMsg);
        if (errorLocator.count() > 0) {
            errorLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
            return errorLocator.textContent();
        } else {
            return null;
        }
    }
}
