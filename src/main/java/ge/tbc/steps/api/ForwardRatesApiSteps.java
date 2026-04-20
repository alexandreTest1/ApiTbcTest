package ge.tbc.steps.api;

import ge.tbc.data.Constants;
import ge.tbc.models.TreasurySegment;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.*;


public class ForwardRatesApiSteps {
    private Response response;
    private List<TreasurySegment> treasurySegments;

    public ForwardRatesApiSteps getForwardRates() {
        response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .accept(ContentType.JSON)
                .when()
                .get(Constants.Treasury_endpoint);
        return this;
    }

    public ForwardRatesApiSteps deserializeTreasury() {
        this.treasurySegments = Arrays.asList(
                response.jsonPath().getObject("rates", TreasurySegment[].class)
        );
        return this;
    }

    public ForwardRatesApiSteps assertField() {
        response.then()
                .assertThat()
                .statusCode(200)
                .body("rates", notNullValue())
                .body("rates.iso", everyItem(notNullValue()))
                .body("rates.forwardRates", everyItem(notNullValue()));
        return this;
    }

    public ForwardRatesApiSteps assertUsdGelExists() {
        response.then()
                .assertThat()
                .body("rates.find { it.iso == 'USD' }.forwardRates.iso2", hasItem("GEL"));
        return this;
    }

    public List<String> getPeriods() {
        return treasurySegments.stream()
                .filter(s -> s.getIso().equals("USD"))
                .flatMap(s -> s.getForwardRates().stream())
                .map(r -> r.getPeriod().trim())
                .collect(Collectors.toList());
    }


    public List<Double> getBidRates() {
        List<Float> floats = response.jsonPath()
                .getList("rates.find { it.iso == 'USD' }.forwardRates.bidForwardRate");
        return floats.stream()
                .map(f -> Double.parseDouble(f.toString()))
                .collect(Collectors.toList());
    }

    public List<Double> getAskRates() {
        List<Float> floats = response.jsonPath()
                .getList("rates.find { it.iso == 'USD' }.forwardRates.askForwardRate");
        return floats.stream()
                .map(f -> Double.parseDouble(f.toString()))
                .collect(Collectors.toList());
    }


}