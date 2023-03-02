package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Proxy;

public class customerPortalTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false).setProxy(new Proxy("http://squid.corp.redhat.com:3128"))    );

        BrowserContext bcx1 = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));

        Page p1 = bcx1.newPage();

        p1.navigate("https://access.qa.redhat.com/support/cases/");
        System.out.println(p1.title());
    
        p1.locator("#username-verification").fill("rhn-support-swjadhav");
        p1.locator("button#login-show-step2").click();
        p1.locator("#password").fill("redhat");

        p1.locator("button#rh-password-verification-submit-button").click();

        // System.exit(0);
    }
}
