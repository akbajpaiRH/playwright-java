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
        p1.close();
        bcx1.close();

        BrowserContext bcx2 = browser.newContext();
		Page p2 = bcx2.newPage();
        p2.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

        Locator country = p2.locator("select#Form_getForm_Country option");
        for(int i=0;i<country.count();i++){
            String text = country.nth(i).textContent();
            System.out.println(text);
        }
        p2.close();
        bcx2.close();
    }
}
