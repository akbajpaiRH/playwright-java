package PlaywrightSessions;

import java.util.List;

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

        // for (int i = 0; i < country.count(); i++) {
        //     String text = country.nth(i).textContent();
        //     System.out.println(text);
        // }

        List<String> options = country.allTextContents();
        // for(String e:options){
        //     System.out.println(e);
        // }
        options.forEach(e -> System.out.println(e));
        System.out.println(country.count());
        
        Page page = browser.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
        
        // text-selector
        Locator l1 = page.locator("div.card-body h2:has-text('New Customer')"); // parent-child relationship
        System.out.println(l1.textContent());

        Locator l2 = page.locator("'Login'");
        System.out.println("There are "+l2.count()+" number of Login present");
        
        page.locator("form button:has-text('Login')").click();
        Locator l3 = page.locator("div.card-body a:has-text('Continue')");
        l3.click();
        
        System.exit(0);
    }
}
