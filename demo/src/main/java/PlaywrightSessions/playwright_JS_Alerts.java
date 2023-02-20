package PlaywrightSessions;

import com.microsoft.playwright.*;

public class playwright_JS_Alerts {
    public static void main(String[] args)throws InterruptedException{
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser.newContext();

        Page p1 = bcx1.newPage();
        p1.onDialog(dialog ->{
            String text = dialog.message();
            System.out.print(text+"\n");
            dialog.accept("Hello from Akash Bajpai, Red Hat");
        });

        p1.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        String res="";
        p1.click("//button[text()='Click for JS Alert']");
        res = p1.textContent("#result");
        System.out.println(res);
        Thread.sleep(1500);

        p1.click("//button[text()='Click for JS Confirm']");
        res = p1.textContent("#result");
        System.out.println(res);
        Thread.sleep(1500);

        p1.click("//button[text()='Click for JS Prompt']");
        res = p1.textContent("#result");
        System.out.println(res);
        Thread.sleep(1500);
    }
    
}
