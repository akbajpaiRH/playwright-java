package PlaywrightSessions;

import java.util.List;

import com.microsoft.playwright.*;

public class playwrightSelectors {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bcx1 = browser.newContext();

        // text-selector
        Page p1 = bcx1.newPage();
        p1.navigate("https://www.amazon.com");
        List<String> amazonLists = p1.locator("a:has-text('Amazon')").allInnerTexts();

        for (String e : amazonLists) {
            System.out.println(e);
        }
        System.out.println(amazonLists.size());

        // frame-selector
        Page p2 = bcx1.newPage();
        p2.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

        p2.locator("div.details__form-image img").click();
        p2.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8").fill("Akash Bajpai");

        // PAGE --> DOM --> Shadow DOM --> elements
        // PAGE --> DOM --> iFrame --> Shadow DOM --> elements

        // Shadow_DOM selectors
        Page p3 = bcx1.newPage();
        p3.navigate("https://selectorshub.com/xpath-practice-page/");
        // p3.frameLocator("#pact").locator("div#snacktime #tea").fill("Badnaam Chai");

        // visible selectors
        Page p4 = bcx1.newPage();
        p4.navigate("https://www.amazon.com");
        List<String> linksText = p4.locator("a:visible").allInnerTexts();

        for (String e : linksText)
            System.out.println(e);

        System.out.println(linksText.size());

        // selecting elements that contain other elements
        Page p5 = bcx1.newPage();
        p5.navigate("https://www.amazon.com");

        Locator footerLinks = p5.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
        List<String> footerLinksList = footerLinks.allInnerTexts();
        for (String e : footerLinksList) {
            System.out.println(e);
        }
        System.out.println(footerLinksList.size());

        // selecting comma seperated
        Page p6 = bcx1.newPage();
        p6.navigate("https://academy.naveenautomationlabs.com");
        p6.locator("a:has-text('SignIn'), " + "a:has-text('signin'), " + "a:has-text('LogIn'), "
                + "a:has-text('Login'),").click();

        Locator imp_ele = p6
                .locator("span:has-text('Store')," + "span:has-text('signin')," + "a:has-text('EXPLORE COURSES'),");
        System.out.println(imp_ele.count());

        if (imp_ele.count() == 3)
            System.out.println("PASSED");
        else
            System.out.println("NOT PASSED");

        Locator xpath_ele = p6.locator("//span[text()='signin'] | //span[text()='login']");
        System.out.println(xpath_ele.textContent());
        xpath_ele.click();

        // relative css selectors
        Page p7 = bcx1.newPage();
        p7.navigate("https://selectorshub.com/xpath-practice-page/");
        Locator checkboxes = p7.locator("input[type='checkbox']:left-of(:text('Joe.Root'))");
        checkboxes.first().click();

        // nth selectors

        Page p8 = bcx1.newPage();
        p8.navigate("https://www.bigbasket.com/");
        p8.locator("div.footer-links li a >> nth=0").click();
        
        Page p9 = bcx1.newPage();
        p9.navigate("https://www.bigbasket.com/");
        p9.locator("div.footer-links li a >> nth=-1").click();
        
    }
}
