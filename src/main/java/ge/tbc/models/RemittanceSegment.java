package ge.tbc.models;

import java.util.List;

public class RemittanceSegment {
    private String mtSystem;
    private String name;
    private String imageUrl;
    private List<String> currencies;


    public RemittanceSegment() {}

    public String getMtSystem() {
        return mtSystem;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl.substring(imageUrl.lastIndexOf("/") + 1, imageUrl.lastIndexOf(".")).toLowerCase();
    }

    public List<String> getCurrencies() {
        return currencies;
    }

}
