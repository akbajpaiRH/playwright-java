package PlaywrightSessions;

import com.microsoft.playwright.*;

public class test {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser.newContext();

        Page p1 = bcx1.newPage();

        String OTP="";

        p1.navigate("https://qa.one.redhat.com/admin-center/#/");

        p1.locator("input#username").fill("akbajpai");
        p1.locator("input#password").fill("aka475pai"+OTP);

        p1.locator("input#submit").click();

        // p1.close();
        // bcx1.close();
        // browser.close();
        // playwright.close();
        // System.exit(0);
    }
}
