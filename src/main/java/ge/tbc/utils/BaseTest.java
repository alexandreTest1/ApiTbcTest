package ge.tbc.utils;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {
   protected Playwright playwright;
   protected Browser browser;
   protected BrowserContext context;
   protected Page page;

    @BeforeClass
    public void setUp (){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(100));

                context = browser.newContext(
                        new Browser.NewContextOptions().setViewportSize(null));
                        page = context.newPage();

    }

}







