import java.util.*;
import java.math.*;

public class whereIsMyTransport {
    private String agency;
    private Map<String, Double> ideni;

    public whereIsMyTransport(String agency, Map<String, Double> ideni) {
        this.agency = agency;
        this.ideni = ideni;
    }

    public String getAgency() {
        return this.agency;
    }

    public Double calTotScore() {
        Double count = 0.0;
        for (String key : this.ideni.keySet()) {
            count = count + ideni.get(key);
        }
        return (BigDecimal.valueOf(count).setScale(2, RoundingMode.HALF_UP)).doubleValue();
    }

    public ArrayList<String> getDays() {
        ArrayList<String> days = new ArrayList<String>();
        for (String key : this.ideni.keySet()) {
            days.add(key);
        }
        return days;
    }

    public ArrayList<Double> getScores() {
        ArrayList<Double> score = new ArrayList<Double>();
        for (String key : this.ideni.keySet()) {
            score.add(this.ideni.get(key));
        }
        return score;
    }

    // public String toString()
    // {
    // return "[Card: index=" + index + ", symbol=" + symbol + ", value=" + value +
    // "]";
    // }
}
