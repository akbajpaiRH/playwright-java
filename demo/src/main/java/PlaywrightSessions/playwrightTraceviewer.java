package PlaywrightSessions;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class playwrightTraceviewer {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click(new Locator.ClickOptions()
                    .setModifiers(Arrays.asList(KeyboardModifier.SHIFT)));
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Akash");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("test@gmail.com");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Tester@123");
            page.frameLocator("#microfe-popup-login")
                    .getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+91 88960-21521");
            page.frameLocator("#microfe-popup-login")
                    .getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Get Started")).click();
            page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();

            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }

}
