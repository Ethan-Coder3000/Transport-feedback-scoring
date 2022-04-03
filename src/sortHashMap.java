package src;

import java.util.*;
import whereIsMyTransportPackage.whereIsMyTransport;

public class sortHashMap {
    private static Map<String, Double> innerHash = new HashMap<>();
    private static Map<String, Integer> innerCount = new HashMap<>();
    private static ArrayList<whereIsMyTransport> whereIsMyTransportlist = new ArrayList<whereIsMyTransport>();

    private static void performCal() {
        for (int i = 0; i < whereIsMyTransportlist.size(); i++) {
            whereIsMyTransportlist.get(i).performCalc();
        }
    }

    private static void hashMapkeys(ArrayList<String> referenceData, ArrayList<String> scoresData) throws Exception {
        String arr[];
        for (int i = 0; i < scoresData.size(); i++) {
            arr = scoresData.get(i).split(";", 2);
            String valKey = arr[1].replaceAll("\\s.*", "");
            scoresData.set(i, scoresData.get(i).replace(valKey, ""));

            arr = scoresData.get(i).split(";", 2);
            String key = arr[0].replaceAll(" ", "");
            Double val = (double) Integer.parseInt(arr[1].replaceAll(" ", ""));

            innerHash = new HashMap<>();
            innerCount = new HashMap<>();
            if (val == (double) 0 || val == (double) 10 || val > 10) {
                continue;
            } else {
                for (whereIsMyTransport transport : whereIsMyTransportlist) {
                    if (transport.getRoute_identifiers().equals(valKey)) {
                        if (transport.getIden().containsKey(transport.getDay(key))) {
                            innerHash = transport.getIden();
                            innerHash.put(transport.getDay(key), innerHash.get(transport.getDay(key)) + val);
                        } else {
                            innerHash = transport.getIden();
                            innerHash.put(transport.getDay(key), val);
                        }
                        if (transport.getCountMap().containsKey(transport.getDay(key))) {
                            innerCount = transport.getCountMap();
                            innerCount.put(transport.getDay(key), innerCount.get(transport.getDay(key)) + 1);
                        } else {
                            innerCount = transport.getCountMap();
                            innerCount.put(transport.getDay(key), 1);
                        }
                        transport.setIndeni(innerHash);
                        transport.setCount(innerCount);
                    }
                }
            }
        }

    }

    public static ArrayList<whereIsMyTransport> createWMT(ArrayList<String> referenceData, ArrayList<String> scoresData)
            throws Exception {
        for (int i = 0; i < referenceData.size(); i++) {
            String arr[] = referenceData.get(i).split(";", 2);
            whereIsMyTransportlist
                    .add(new whereIsMyTransport(arr[1], arr[0].replaceAll("\\s.*", ""), new HashMap<>(),
                            new HashMap<>()));
        }
        hashMapkeys(referenceData, scoresData);
        performCal();
        return whereIsMyTransportlist;
    }
}