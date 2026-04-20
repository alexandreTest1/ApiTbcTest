package ge.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.data.Constants;

public class TreasuryPage {
    private Page page;
    public final Locator periodItems;
    public final Locator bidRateItems;
    public final Locator askRateItems;

    public TreasuryPage(Page page) {
        this.page = page;
        Locator usdBlock = page.locator("xpath=//span[contains(text(),'USD/GEL')]/following::div[contains(@class,'ag-root-wrapper')][1]");
        periodItems  = usdBlock.locator("div[col-id='period']");
        bidRateItems = usdBlock.locator("div[col-id='buy']");
        askRateItems = usdBlock.locator("div[col-id='sell']");
    }

    public void navigate() {
        page.navigate(Constants.Treasury_URL);
        page.locator("text=USD/GEL").scrollIntoViewIfNeeded();
    }
}