package whereIsMyTransportPackage;

import java.util.*;
import java.math.*;

public class whereIsMyTransport {
    private String agency;
    private Map<String, Double> ideni;
    private Map<String, Integer> count;
    private String route_identifiers;

    public whereIsMyTransport(String agency, String route_identifiers, Map<String, Double> ideni,
            Map<String, Integer> count) {
        this.agency = agency;
        this.route_identifiers = route_identifiers;
        this.ideni = ideni;
        this.count = count;
    }

    public void setIndeni(Map<String, Double> ideni) {
        this.ideni = ideni;
    }

    public void setCount(Map<String, Integer> countm) {
        this.count = countm;
    }

    public Integer getCount(String key) {
        return this.count.get(key);
    }

    public Map<String, Integer> getCountMap() {
        return this.count;
    }

    public void setRoute_identifiers(String route_identifiers) {
        this.route_identifiers = route_identifiers;
    }

    public String getRoute_identifiers() {
        return this.route_identifiers;
    }

    public Double getValId(String key) {
        return this.ideni.get(key);
    }

    public String getAgency() {
        return this.agency;
    }

    public Map<String, Double> getIden() {
        return this.ideni;
    }

    public Double calTotScore() {
        Map<String, Double> totAve = ideni;
        Double countVal = 0.0;
        for (String key : totAve.keySet()) {
            countVal = countVal + totAve.get(key);
        }
        System.out.println(ideni);
        return (double) (BigDecimal.valueOf(countVal).setScale(2, RoundingMode.HALF_UP)).doubleValue();
    }

    public void performCalc() {
        Map<String, Double> performcalc = ideni;
        for (String key : performcalc.keySet()) {
            performcalc.put(key, (double) BigDecimal.valueOf(performcalc.get(key) / count.get(key)).setScale(2,
                    RoundingMode.HALF_UP)
                    .doubleValue());
        }
        this.ideni = performcalc;
    }

    private Map<String, Double> sortHash() {
        Map<String, Double> sortH;
        sortH = ideni;
        LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
        sortH.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    @Override
    public String toString() {
        String outString = "";
        this.ideni = sortHash();
        for (String key : ideni.keySet()) {
            outString = outString + this.agency + " " + key + " " + ideni.get(key) + "\n";
        }
        return outString;
    }
}
