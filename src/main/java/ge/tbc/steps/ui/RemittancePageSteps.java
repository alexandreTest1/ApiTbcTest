package ge.tbc.steps.ui;

import com.microsoft.playwright.Page;
import ge.tbc.pages.RemittancePage;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class RemittancePageSteps {
    public final RemittancePage remittancePage;
    private List<String> uiCardNames;
    private List<String > uiCardCurrencies;
    private List<String> uiCardImages;

    public RemittancePageSteps(Page page){
        this.remittancePage = new RemittancePage(page);

    }


    public RemittancePageSteps navigateToRemittancePage(){
        remittancePage.navigate();
        return this;
    }

    public RemittancePageSteps getMenuCards(){
        remittancePage.cardItems.first().waitFor();
        uiCardNames = remittancePage.cardItems.allInnerTexts();
        return this;
    }


    public RemittancePageSteps getCurrencyCards(){
        remittancePage.cardCurrency.first().waitFor();
        uiCardCurrencies = remittancePage.cardCurrency.allInnerTexts();
        return this;
    }


    public RemittancePageSteps getCardImages() {
        remittancePage.cardImage.first().waitFor();
        uiCardImages = remittancePage.cardImage.all().stream()
                .map(img -> img.getAttribute("style"))
                .map(style -> {
                    int start = style.lastIndexOf("/") + 1;
                    int end = style.lastIndexOf(".");
                    return style.substring(start, end).toLowerCase();
                })
                .collect(Collectors.toList());
        System.out.println("UI IMAGES: " + uiCardImages);
        return this;
    }


    public RemittancePageSteps assertMenuNamesMatch(List<String> apiNames){
        assertThat(uiCardNames, containsInAnyOrder(apiNames.toArray()));
        return this;

    }


        public RemittancePageSteps assertCurrencyMatch(List<String> apiCurrencies){
        assertThat(uiCardCurrencies, containsInAnyOrder(apiCurrencies.toArray()));
        return  this;

    }

    public RemittancePageSteps assertImageMatch(List<String> apiImages) {
        System.out.println("API IMAGES: " + apiImages);
        assertThat(uiCardImages, containsInAnyOrder(apiImages.toArray()));
        return this;
    }


}
