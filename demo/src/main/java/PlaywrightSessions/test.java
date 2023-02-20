package PlaywrightSessions;

// import java.util.List;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Proxy;

public class test {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        launchOptions.setProxy(new Proxy("http://squid.corp.redhat.com:3128"));
        Browser browser = playwright.firefox().launch(launchOptions);

        BrowserContext bcx1 = browser.newContext();

        Page p1 = bcx1.newPage();

        // String OTP = "";
        // String password="aka475pai"+OTP;

        p1.navigate("https://qa.one.redhat.com/admin-center/#/");

        // p1.locator("input#username").fill("akbajpai");
        // p1.locator("input#password").fill(password);

        // p1.locator("input#submit").click();

        // p1.close();
        // bcx1.close();
        // browser.close();
        // playwright.close();
        // System.exit(0);
    }
}
