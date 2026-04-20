package ge.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.data.Constants;

public class RemittancePage {
    private Page page;
    public final Locator cardItems;
    public final Locator cardImage;
    public final Locator cardCurrency;


    public RemittancePage(Page page){
        this.page = page;
        cardItems = page.locator("div.tbcx-pw-card__logo-and-text-info");
        cardCurrency = page.locator("span.tbcx-pw-card__caption");
        cardImage = page.locator("//tbcx-avatar/div");

    }

    public void navigate(){
        page.navigate(Constants.Remittance_URL);
    }

}
