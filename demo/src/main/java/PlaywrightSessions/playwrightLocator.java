package PlaywrightSessions;

import com.microsoft.playwright.*;

public class playwrightLocator {
    public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bcx1 = browser.newContext();
		Page p1 = bcx1.newPage();
        p1.navigate("https://academy.naveenautomationlabs.com/");

        Locator lgn = p1.locator("text = Login");
        System.out.println(lgn.count());

        lgn.first().click();
    }
}
