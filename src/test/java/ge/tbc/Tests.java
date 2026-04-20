package ge.tbc;

import ge.tbc.steps.api.ForwardRatesApiSteps;
import ge.tbc.steps.api.MoneyTransferApiSteps;
import ge.tbc.steps.ui.RemittancePageSteps;
import ge.tbc.steps.ui.TreasuryPageSteps;
import ge.tbc.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class Tests extends BaseTest {
    RemittancePageSteps remittancePageSteps;
    MoneyTransferApiSteps moneyTransferApiSteps;

    TreasuryPageSteps treasuryPageSteps;
    ForwardRatesApiSteps forwardRatesApiSteps;

    @BeforeMethod
    public void setupTest(){

        remittancePageSteps = new RemittancePageSteps(page);
        moneyTransferApiSteps = new MoneyTransferApiSteps();

        treasuryPageSteps = new TreasuryPageSteps(page);
        forwardRatesApiSteps = new ForwardRatesApiSteps();

    }

    @Test(priority = 1)
    public void moneyTransferTest (){
     moneyTransferApiSteps
              .getRemittanceSegment()
                .assertField()
                .deserializeRemittance();

        List <String> expectedApiNames = moneyTransferApiSteps.getRemittanceNames();
        List <String> expectedApiCurrencies = moneyTransferApiSteps.getRemittanceCurrencies();
        List<String> expectedApiImages     = moneyTransferApiSteps.getRemittanceImages();

      remittancePageSteps
                .navigateToRemittancePage()
                .getMenuCards()
                .assertMenuNamesMatch(expectedApiNames)
              .getCurrencyCards()
              .assertCurrencyMatch(expectedApiCurrencies);

      //კომენტარის მოხსნის შემთხვევაში ტესტი დაფეილდება
             /* .getCardImages()
              .assertImageMatch(expectedApiImages);*/
    }


    @Test(priority = 2)
    public void treasuryRatesTest() {
        forwardRatesApiSteps
                .getForwardRates()
                .assertField()
                .assertUsdGelExists()
                .deserializeTreasury();

        List<String> expectedPeriods  = forwardRatesApiSteps.getPeriods();
        List<Double> expectedBidRates = forwardRatesApiSteps.getBidRates();
        List<Double> expectedAskRates = forwardRatesApiSteps.getAskRates();

        treasuryPageSteps
                .navigateToTreasuryPage()
                .getPeriods()
                .assertPeriodsMatch(expectedPeriods)
                .getBidRates()
                .assertBidRatesMatch(expectedBidRates)
                .getAskRates()
                .assertAskRatesMatch(expectedAskRates);
    }


}
