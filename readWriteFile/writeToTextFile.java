package readWriteFile;

import java.io.*;
import whereIsMyTransportPackage.whereIsMyTransport;
import java.util.*;

public class writeToTextFile {
    public static void writeText(ArrayList<whereIsMyTransport> whereIsMyTransportlist, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < whereIsMyTransportlist.size(); i++) {
                writer.write(whereIsMyTransportlist.get(i).toString());
            }
            writer.close();
            System.out.println("Success");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}