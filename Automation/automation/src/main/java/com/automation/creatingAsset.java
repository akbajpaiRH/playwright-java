package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class creatingAsset {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser.newContext();

        Page page = bcx1.newPage();

        page.navigate("https://qa.one.redhat.com/admin-center/");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New Asset")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText("Select Asset Type")).nth(2).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Courses")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText("Select Status")).nth(1).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Draft")).click();
        page.getByPlaceholder("Topic").click();
        page.getByPlaceholder("Topic").fill("abcd");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("Select Team Name")).nth(1).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("App Services Team")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

    }
}
