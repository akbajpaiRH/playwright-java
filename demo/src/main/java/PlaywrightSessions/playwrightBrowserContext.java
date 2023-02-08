package PlaywrightSessions;

import com.microsoft.playwright.*;

public class playwrightBrowserContext {
    public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bcx1 = browser.newContext();
		Page p1 = bcx1.newPage();
		p1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		p1.fill("#Form_getForm_subdomain", "Akash");
		
		System.out.println(p1.title()); //Form_getForm_Country

		
		BrowserContext bcx2 = browser.newContext();
		Page p2 = bcx1.newPage();
		p2.navigate("https://www.amazon.in/");
		p2.fill("#twotabsearchtextbox", "iphone 14");
		System.out.println(p2.title());
		
		bcx1.close();  
		bcx2.close();
	}
}
