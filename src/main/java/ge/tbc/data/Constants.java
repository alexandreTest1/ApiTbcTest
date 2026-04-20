package ge.tbc.data;

public class Constants {

    public static final String BASE_URL = "https://apigw.tbcbank.ge";
    public static final String Remittance_URL = "https://tbcbank.ge/ka/other-products/money-transfers";
    public static final String Remittance_endpoint = "/api/v1/moneyTransfer/systems?locale=ka-GE";
    public static final String Treasury_URL = "https://tbcbank.ge/ka/treasury-products?amount=100&ccyFrom=USD&ccyTo=GEL";
    public static final String Treasury_endpoint = "/api/v1/forwardRates/getForwardRates?locale=ka-GE";
}
