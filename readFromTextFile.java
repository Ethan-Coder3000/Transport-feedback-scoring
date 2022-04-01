import java.io.*;
import java.util.*;

public class readFromTextFile {
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
}
