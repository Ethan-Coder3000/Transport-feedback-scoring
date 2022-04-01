import java.util.*;

public class sortHashMap {
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm) {
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                    Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void hashMapkeys(ArrayList<String> referenceData, ArrayList<String> scoresData,
            Map<String, Double> innerHash,
            Map<String, Integer> innerCount,
            Map<String, Map<String, Integer>> CountHash,
            Map<String, Map<String, Double>> sortingMap) throws Exception {
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
                    // innerHash.put(key, (double) Math.round(val / 2));
                    innerHash.put(key, (double) val);
                    sortingMap.put(valKey, innerHash);

                    innerCount = new HashMap<>();
                    innerCount.put(key, 1);
                    CountHash.put(valKey, innerCount);
                }
            }
        }
        System.out.println(sortingMap);
        System.out.println(CountHash);

    }

}
