package com.example;

import java.lang.Thread;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class UIAutomation {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser.newContext();

        Page p1 = bcx1.newPage();

        p1.navigate("https://www.amazon.in");

        p1.locator("#nav-hamburger-menu").click();
        p1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Best Sellers")).click();
        p1.locator(("input#twotabsearchtextbox")).fill("I phone");
        p1.locator(("input#nav-search-submit-button")).click();
        Page tpage = p1.waitForPopup(() -> {
            p1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apple iPhone 14 128GB (Product) RED"))
                    .nth(1).click();
        });
        tpage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buy Now")).click();
        tpage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create your Amazon account")).click();
        tpage.getByPlaceholder("First and last name").fill("Tester Guy");
        tpage.getByPlaceholder("Mobile number").click();
        tpage.getByPlaceholder("Mobile number").fill("9999999999");
        tpage.getByPlaceholder("At least 6 characters").click();
        tpage.getByPlaceholder("At least 6 characters").fill("tester123");
        tpage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        Thread.sleep(1000);
        tpage.close();

        Page page = bcx1.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.getByPlaceholder("Enter email").click();
        page.getByPlaceholder("Enter email").fill("tester123@gmail.com");
        page.getByPlaceholder("Enter Password").click();
        page.getByPlaceholder("Enter Password").fill("tester123");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your company")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your company"))
                .fill("Test Technologies");
        page.getByRole(AriaRole.SPINBUTTON).click();
        page.getByRole(AriaRole.SPINBUTTON).fill("9999999999");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        page.locator("input[name=\"the_date\"]").fill("2023-03-02");
        page.getByPlaceholder("Enter pizza name").click();
        page.getByPlaceholder("enter name", new Page.GetByPlaceholderOptions().setExact(true)).fill("Pizza Guy");
        page.getByPlaceholder("Enter pizza name").fill("Golden Corn");
        page.getByPlaceholder("enter name", new Page.GetByPlaceholderOptions().setExact(true)).click();
        Thread.sleep(1000);

        Page page1 = bcx1.newPage();
        page1.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        page1.getByTitle("vehicle-registration-forms-and-templates").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Vehicle year *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Vehicle year *").fill("2023");
        page1.frameLocator("#frame-one748593425").getByPlaceholder("Ford, Honda, etc.").click();
        page1.frameLocator("#frame-one748593425").getByPlaceholder("Ford, Honda, etc.").fill("Toyota");
        page1.frameLocator("#frame-one748593425").getByPlaceholder("F-150, Highlander, etc.").click();
        page1.frameLocator("#frame-one748593425").getByPlaceholder("F-150, Highlander, etc.").fill("Fortuner");
        page1.frameLocator("#frame-one748593425").getByLabel("Color *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Color *").fill("Black");
        page1.frameLocator("#frame-one748593425").getByLabel("Mileage *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Mileage *").fill("15");
        page1.frameLocator("#frame-one748593425").getByLabel("Vehicle Identification Number (VIN) *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Vehicle Identification Number (VIN) *")
                .fill("ABCDEFGH12345678");
        page1.frameLocator("#frame-one748593425").getByLabel("Name *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Name *").fill("Test Man");
        page1.frameLocator("#frame-one748593425")
                .getByLabel("Address *", new FrameLocator.GetByLabelOptions().setExact(true)).click();
        page1.frameLocator("#frame-one748593425")
                .getByLabel("Address *", new FrameLocator.GetByLabelOptions().setExact(true)).fill("Tester colony");
        page1.frameLocator("#frame-one748593425").getByLabel("City *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("City *").fill("Test Nagar");
        page1.frameLocator("#frame-one748593425")
                .getByRole(AriaRole.COMBOBOX, new FrameLocator.GetByRoleOptions().setName("State *"))
                .selectOption("Radio-0");
        page1.frameLocator("#frame-one748593425").getByLabel("Zip *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Zip *").fill("123456");
        page1.frameLocator("#frame-one748593425").getByLabel("Phone *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Phone *").fill("9999999999");
        page1.frameLocator("#frame-one748593425").getByLabel("Email address *").click();
        page1.frameLocator("#frame-one748593425").getByLabel("Email address *").fill("tester@gmail.com");
        page1.frameLocator("#frame-one748593425")
                .getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Submit")).click();
        Thread.sleep(1000);
        page1.close();
        Thread.sleep(1000);
        page.close();
        Thread.sleep(2000);
        p1.close();
    }
}
