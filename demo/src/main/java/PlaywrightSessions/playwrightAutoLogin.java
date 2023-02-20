package PlaywrightSessions;
import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class playwrightAutoLogin {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    
        BrowserContext bcx1 = browser.newContext();
    
        Page p1 = bcx1.newPage();

        p1.navigate("https://practicetestautomation.com/practice-test-login/");

        p1.fill("#username","student");
        p1.fill("#password","Password123");
        p1.click("#submit");

        bcx1.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin.json")));
    }
    
}
