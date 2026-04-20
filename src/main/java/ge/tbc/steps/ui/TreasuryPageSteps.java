package ge.tbc.steps.ui;

import com.microsoft.playwright.Page;
import ge.tbc.pages.TreasuryPage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TreasuryPageSteps {
    public final TreasuryPage treasuryPage;
    private List<String> uiPeriods;
    private List<String> uiBidRates;
    private List<String> uiAskRates;

    public TreasuryPageSteps(Page page) {
        this.treasuryPage = new TreasuryPage(page);
    }

    public TreasuryPageSteps navigateToTreasuryPage() {
        treasuryPage.navigate();
        return this;
    }

    public TreasuryPageSteps getPeriods() {
        treasuryPage.periodItems.first().waitFor();
        uiPeriods = new ArrayList<>(treasuryPage.periodItems.allInnerTexts());
        uiPeriods = uiPeriods.subList(1, uiPeriods.size());
        return this;
    }

    public TreasuryPageSteps getBidRates() {
        treasuryPage.bidRateItems.first().waitFor();
        uiBidRates = new ArrayList<>(treasuryPage.bidRateItems.allInnerTexts());
        uiBidRates = uiBidRates.subList(1, uiBidRates.size());
        return this;
    }

    public TreasuryPageSteps getAskRates() {
        treasuryPage.askRateItems.first().waitFor();
        uiAskRates = new ArrayList<>(treasuryPage.askRateItems.allInnerTexts());
        uiAskRates = uiAskRates.subList(1, uiAskRates.size());
        return this;
    }

    public TreasuryPageSteps assertPeriodsMatch(List<String> apiPeriods) {
        assertThat(uiPeriods, containsInAnyOrder(apiPeriods.toArray()));
        return this;
    }

    public TreasuryPageSteps assertBidRatesMatch(List<Double> apiBidRates) {
        List<Double> uiDoubles = uiBidRates.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        return this;
    }

    public TreasuryPageSteps assertAskRatesMatch(List<Double> apiAskRates) {
        List<Double> uiDoubles = uiAskRates.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        return this;

    }
}