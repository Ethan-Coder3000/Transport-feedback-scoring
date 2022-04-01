/* Ethan Lourens
Transport feedback scoring
*/

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import whereIsMyTransportPackage.whereIsMyTransport;

public class main_File {
    private static ArrayList<String> referenceData = new ArrayList<String>();
    private static ArrayList<String> scoresData = new ArrayList<String>();
    private static ArrayList<whereIsMyTransport> whereIsMyTransportlist = new ArrayList<whereIsMyTransport>();

    public static String getDay(String dayN) throws Exception {
        Format formatDate = new SimpleDateFormat("EEEE");
        Date dateIn = new SimpleDateFormat("yyyy/mm/dd").parse(dayN);
        String out = formatDate.format(dateIn);
        return out;
    }

    public static void inputFiles(ArrayList<String> arraylistName, String fileName) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
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

    public void run() throws Exception {
        inputFiles(referenceData, "reference-data.txt");
        inputFiles(scoresData, "scores.txt");
        whereIsMyTransportlist = sortHashMap.createWMT(referenceData, scoresData);
        for (int i = 0; i < whereIsMyTransportlist.size(); i++) {
            System.out.println(whereIsMyTransportlist.get(i).calTotScore());
        }
    }

    public static void main(String[] args) throws Exception {
        main_File obj = new main_File();
        obj.run();
    }
}