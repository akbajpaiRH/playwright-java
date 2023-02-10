package PlaywrightSessions;

import java.util.List;

import com.microsoft.playwright.*;

public class playwrightSelectors {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser.newContext();
        Page p1 = bcx1.newPage();

        p1.navigate("https://www.amazon.com");
        List<String> amazonLists= p1.locator("a:has-text('Amazon')").allInnerTexts(); 

        for(String e:amazonLists){
            System.out.println(e);
        }
    }
}
