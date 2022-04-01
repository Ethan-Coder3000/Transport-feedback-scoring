import java.io.*;
import whereIsMyTransportPackage.whereIsMyTransport;
import java.util.*;

public class writeToTextFile {
    public static void writeText(ArrayList<whereIsMyTransport> whereIsMyTransportlist) {
        try {
            FileWriter myWriter = new FileWriter("results.txt");
            for (int i = 0; i < whereIsMyTransportlist.size(); i++) {
                myWriter.write(whereIsMyTransportlist.get(i).toString());
            }
            myWriter.close();
            System.out.println("Success");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}