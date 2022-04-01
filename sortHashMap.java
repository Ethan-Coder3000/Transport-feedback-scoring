import java.math.*;
import java.util.*;

public class sortHashMap {
    private static Map<String, Double> innerHash = new HashMap<>();
    private static Map<String, Integer> innerCount = new HashMap<>();
    private static Map<String, Map<String, Integer>> CountHash = new HashMap<>();
    private static Map<String, Map<String, Double>> sortingMap = new HashMap<>();

    private static void sortHash() {
        Map<String, Double> sortH;
        for (String key : sortingMap.keySet()) {
            sortH = sortingMap.get(key);
            LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
            sortH.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
            sortingMap.put(key, sortedMap);
        }
    }

    private static void performCalc() {
        Map<String, Double> temp = new HashMap<>();
        for (String key : sortingMap.keySet()) {
            for (String keyC : sortingMap.get(key).keySet()) {
                sortingMap.get(key).put(keyC, (double) BigDecimal.valueOf((sortingMap.get(key).get(keyC))
                        / (Double) Double.valueOf(CountHash.get(key).get(keyC))).setScale(2, RoundingMode.HALF_UP)
                        .doubleValue());
            }
        }
    }

    public static void hashMapkeys(ArrayList<String> referenceData, ArrayList<String> scoresData) throws Exception {
        String arr[];
        String valKey;
        for (int i = 0; i < scoresData.size(); i++) {
            String dateEx = scoresData.get(i).substring(0, scoresData.get(i).indexOf(";"));
            scoresData.set(i, scoresData.get(i).replace(dateEx, main_File.getDay(dateEx)));
            arr = scoresData.get(i).split(";", 2);
            valKey = arr[1].replaceAll("\\s.*", "");
            scoresData.set(i, scoresData.get(i).replace(valKey, ""));
            arr = scoresData.get(i).split(";", 2);
            String key = arr[0];
            Double val = (double) Integer.parseInt(arr[1].replaceAll(" ", ""));
            if (sortingMap.containsKey(valKey)) {
                if (sortingMap.get(valKey).containsKey(key)) {
                    if (val == (double) 0 || val == (double) 10) {
                        continue;
                    } else {
                        innerHash = new HashMap<>();
                        innerHash = sortingMap.get(valKey);
                        innerHash.put(key, innerHash.get(key) + (double) val);
                        sortingMap.put(valKey, innerHash);

                        innerCount = new HashMap<>();
                        innerCount = CountHash.get(valKey);
                        innerCount.put(key, innerCount.get(key) + 1);
                        CountHash.put(valKey, innerCount);
                    }
                } else {
                    if (val == (double) 0 || val == (double) 10) {
                        continue;
                    } else {
                        innerHash = new HashMap<>();
                        innerHash = sortingMap.get(valKey);
                        innerHash.put(key, (double) val);
                        sortingMap.put(valKey, innerHash);

                        innerCount = new HashMap<>();
                        innerCount = CountHash.get(valKey);
                        innerCount.put(key, 1);
                        CountHash.put(valKey, innerCount);
                    }
                }
            } else {
                if (val == (double) 0 || val == (double) 10) {
                    continue;
                } else {
                    innerHash = new HashMap<>();
                    innerHash.put(key, (double) val);
                    sortingMap.put(valKey, innerHash);

                    innerCount = new HashMap<>();
                    innerCount.put(key, 1);
                    CountHash.put(valKey, innerCount);
                }
            }
        }
        System.out.println(sortingMap + "\n");
        System.out.println(CountHash);
        performCalc();
        sortHash();
        System.out.println(sortingMap + "\n");
    }

}
