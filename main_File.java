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

    public static String getDay(String dayN) throws Exception {
        Format formatDate = new SimpleDateFormat("EEEE");
        Date dateIn = new SimpleDateFormat("yyyy/mm/dd").parse(dayN);
        String out = formatDate.format(dateIn);
        return out;
    }

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

    public void run() throws Exception {
        inputFiles(referenceData, "reference-data.txt");
        inputFiles(scoresData, "scores.txt");
        sortHashMap.hashMapkeys(referenceData, scoresData);
    }

    public static void main(String[] args) throws Exception {
        main_File obj = new main_File();
        obj.run();
    }
}