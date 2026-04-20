package ge.tbc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

public class TreasurySegment {
    private String iso;
    private List<ForwardRate> forwardRates;

    public TreasurySegment() {}

    public String getIso() { return iso; }
    public List<ForwardRate> getForwardRates() { return forwardRates; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ForwardRate {
        private String iso1;
        private String iso2;
        private String period;
        private Integer day;
        private String bidForwardRate;
        private String askForwardRate;

        public ForwardRate() {}

        public String getIso1() { return iso1; }
        public String getIso2() { return iso2; }
        public String getPeriod() { return period; }
        public Integer getDay() { return day; }
        public String getBidForwardRate() { return bidForwardRate; }
        public String getAskForwardRate() { return askForwardRate; }
    }
}