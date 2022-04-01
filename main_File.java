/* Ethan Lourens
Transport feedback scoring
*/

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

public class main_File {
    public static ArrayList<String> referenceData = new ArrayList<String>();
    public static ArrayList<String> scoresData = new ArrayList<String>();
    public static ArrayList<String> testArray = new ArrayList<String>();
    public static Map<String, Integer> innerHash = new HashMap<>();
    public static Map<String, Map<String, Integer>> sortingMap = new HashMap<>();

    public static String getDay(String dayN) throws Exception {
        Format formatDate = new SimpleDateFormat("EEEE");
        Date dateIn = new SimpleDateFormat("yyyy/mm/dd").parse(dayN);
        String out = formatDate.format(dateIn);
        return out;
    }

    // public static void sortDates(String key) {
    // Integer count;
    // ArrayList<String> test = new ArrayList<String>();
    // ArrayList<String> tempArr = new ArrayList<String>();
    // test = sortingMap.get(key);
    // for (int i = 0; i < test.size(); i++) {
    // count = 0;
    // for (int j = 1; i < test.size(); i++) {
    // if ((test.get(i).replaceAll("\\s.*",
    // "")).equals(test.get(j).replaceAll("\\s.*", ""))) {
    // String arr[] = scoresData.get(i).split(";", 2);
    // String arrT[] = scoresData.get(j).split(";", 2);
    // String q = arr[1];
    // String qT = arrT[1];
    // if (Integer.parseInt(q) != 0 || Integer.parseInt(q) != 10
    // || (Integer.parseInt(qT) != 0 || Integer.parseInt(qT) != 10)) {
    // count++;
    // count = count + Integer.parseInt(q) + Integer.parseInt(qT);
    // tempArr.add()

    // }
    // }
    // }
    // }
    // }

    public static void inputFiles(ArrayList<String> arraylistName, String fileName) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                arraylistName.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void hashMapkeys() throws Exception {
        String arr[];
        String valKey;
        for (int i = 0; i < scoresData.size(); i++) {
            innerHash = new HashMap<>();
            String dateEx = scoresData.get(i).substring(0, scoresData.get(i).indexOf(";"));
            scoresData.set(i, scoresData.get(i).replace(dateEx, getDay(dateEx)));
            arr = scoresData.get(i).split(";", 2);
            valKey = arr[1].replaceAll("\\s.*", "");
            scoresData.set(i, scoresData.get(i).replace(valKey, ""));
            arr = scoresData.get(i).split(";", 2);
            String key = arr[0];
            Integer val = Integer.parseInt(arr[1].replaceAll(" ", ""));
            if (sortingMap.containsKey(valKey)) {
                if (innerHash.containsKey(key)) {
                    if (!val.equals(0) || !val.equals(10)) {
                        innerHash.put(key, innerHash.get(key) + (val / 2));
                        sortingMap.put(valKey, innerHash);
                    }
                } else {
                    if (!val.equals(0) || !val.equals(10)) {
                        innerHash.put(key, val / 2);
                        sortingMap.put(valKey, innerHash);
                    }
                }
            } else {
                // testArray = new ArrayList<String>();
                // testArray.add(scoresData.get(i).replace(valKey, ""));
                if (!val.equals(0) || !val.equals(10)) {
                    innerHash = new HashMap<>();
                    innerHash.put(key, val / 2);
                    sortingMap.put(valKey, innerHash);
                }
            }
        }
        System.out.println(sortingMap);

    }

    public void run() throws Exception {
        inputFiles(referenceData, "reference-data.txt");
        inputFiles(scoresData, "scores.txt");
        hashMapkeys();
    }

    public static void main(String[] args) throws Exception {
        main_File obj = new main_File();
        obj.run();
    }
}