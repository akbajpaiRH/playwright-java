package PlaywrightSessions;

import java.nio.file.Paths;
import java.util.List;

// import java.util.List;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class test {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser
                .newContext();

        Page page = bcx1.newPage();

        page.navigate("https://qa.one.redhat.com/admin-center/");
        page.locator("input.pf-c-search-input__text-input").click();
        page.locator("input.pf-c-search-input__text-input").fill("Briefing");
        page.locator("input.pf-c-search-input__text-input").press("Enter");
        // page.locator(null);

        
    }
}
