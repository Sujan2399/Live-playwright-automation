package com.playwright.playwright_java;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class DashboardMySchool {

    private Page page;

    public DashboardMySchool(Page page) {
        this.page = page;
    }

    public void goToDashboard() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard")).click();
        page.waitForTimeout(2000);
    }

    public void selectSchool(String schoolName) {
        page.getByTitle("Select School").click();
        page.waitForTimeout(2000);
        page.getByPlaceholder(" Search Schools").fill(schoolName);
        page.waitForTimeout(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(schoolName)).click();
        page.waitForTimeout(2000);
    }

    public void goToProfile() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My School ")).click();
        page.waitForTimeout(2000);
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("• Profile ")).click();
        page.waitForTimeout(2000);
    }

    public void goToYearSection() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("• Year")).click();
        page.waitForTimeout(2000);
    }

    public void updateAcademicYear(String year) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
        page.waitForTimeout(2000);
        page.locator("#academicName").fill(year);
        page.waitForTimeout(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        page.waitForTimeout(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();
        page.waitForTimeout(2000);
    }
}
