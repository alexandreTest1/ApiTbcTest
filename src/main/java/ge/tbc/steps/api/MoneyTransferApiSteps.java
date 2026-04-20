package ge.tbc.steps.api;
import ge.tbc.data.Constants;
import ge.tbc.models.RemittanceSegment;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.*;


public class MoneyTransferApiSteps {
    private Response response;
    private List<RemittanceSegment> remittanceSegments;

    public MoneyTransferApiSteps getRemittanceSegment(){
        response =  RestAssured.given()
                    .baseUri(Constants.BASE_URL)
                    .accept(ContentType.JSON)
                    .when()
                    .get(Constants.Remittance_endpoint);
        return this;
    }


    public MoneyTransferApiSteps deserializeRemittance(){
        this.remittanceSegments = Arrays.asList(response.as(RemittanceSegment[].class));
        return this;

    }

    public List<String> getRemittanceNames(){
        return remittanceSegments.stream()
                .map(s -> s.getName().trim())
                .collect(Collectors.toList());

    }


    public List<String> getRemittanceCurrencies() {
        return remittanceSegments.stream()
                .map(segment -> {
                    String joined = String.join("/", segment.getCurrencies());
                    return "currency - " + joined;
                })
                .collect(Collectors.toList());
    }


    public List<String> getRemittanceImages() {
        return remittanceSegments.stream()
                .map(s -> s.getImageUrl())
                .collect(Collectors.toList());
    }


    public MoneyTransferApiSteps assertField(){
        response.then()
                .assertThat()
                .statusCode(200)
                .body("name", everyItem(notNullValue()))
                .body("mtSystem", everyItem(notNullValue()))
                .body("imageUrl", everyItem(notNullValue()));
        return this;

    }

}
