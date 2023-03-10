package PlaywrightSessions;

import java.nio.file.Paths;

// import java.util.List;

import com.microsoft.playwright.*;

public class test {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    
        BrowserContext bcx1 = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin.json")));
    
        Page p1 = bcx1.newPage();

        p1.navigate("https://practicetestautomation.com/practice-test-login/");
    }
}
