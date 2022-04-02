package src;

import java.util.*;
import whereIsMyTransportPackage.whereIsMyTransport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

public class sortHashMap {
    private static Map<String, Double> innerHash = new HashMap<>();
    private static Map<String, Integer> innerCount = new HashMap<>();
    private static ArrayList<whereIsMyTransport> whereIsMyTransportlist = new ArrayList<whereIsMyTransport>();

    private static String getDay(String dayN) throws Exception {
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("u/M/d", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dayN, datef);
        String out = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return out;
    }

    private static void performCal() {
        for (int i = 0; i < whereIsMyTransportlist.size(); i++) {
            whereIsMyTransportlist.get(i).performCalc();
        }
    }

    private static void hashMapkeys(ArrayList<String> referenceData, ArrayList<String> scoresData) throws Exception {
        String arr[];
        String valKey;
        for (int i = 0; i < scoresData.size(); i++) {
            arr = scoresData.get(i).split(";", 2);
            valKey = arr[1].replaceAll("\\s.*", "");
            scoresData.set(i, scoresData.get(i).replace(valKey, ""));

            arr = scoresData.get(i).split(";", 2);
            String key = getDay(arr[0].replaceAll(" ", ""));
            Double val = (double) Integer.parseInt(arr[1].replaceAll(" ", ""));

            innerHash = new HashMap<>();
            innerCount = new HashMap<>();
            if (val == (double) 0 || val == (double) 10 || val > 10) {
                continue;
            } else {
                for (whereIsMyTransport transport : whereIsMyTransportlist) {
                    if (transport.getRoute_identifiers().equals(valKey)) {
                        if (transport.getIden().containsKey(key)) {
                            innerHash = transport.getIden();
                            innerHash.put(key, innerHash.get(key) + val);
                        } else {
                            innerHash = transport.getIden();
                            innerHash.put(key, val);
                        }
                        if (transport.getCountMap().containsKey(key)) {
                            innerCount = transport.getCountMap();
                            innerCount.put(key, innerCount.get(key) + 1);
                        } else {
                            innerCount = transport.getCountMap();
                            innerCount.put(key, 1);
                        }
                        transport.setIndeni(innerHash);
                        transport.setCount(innerCount);
                        break;
                    }
                }
            }
        }

    }

    public static ArrayList<whereIsMyTransport> createWMT(ArrayList<String> referenceData, ArrayList<String> scoresData)
            throws Exception {
        for (int i = 0; i < referenceData.size(); i++) {
            String arr[] = referenceData.get(i).split(";", 2);
            Map<String, Double> tempMap = new HashMap<>();
            Map<String, Integer> tempIntMap = new HashMap<>();
            whereIsMyTransportlist
                    .add(new whereIsMyTransport(arr[1], arr[0].replaceAll("\\s.*", ""), tempMap, tempIntMap));
        }
        hashMapkeys(referenceData, scoresData);
        performCal();
        return whereIsMyTransportlist;
    }
}
