
/* Ethan Lourens
Transport feedback scoring
*/
package src;

import java.util.*;
import whereIsMyTransportPackage.whereIsMyTransport;
import comparatorPackage.whereIsMyTransportComparator;
import readWriteFile.readFromTextFile;
import readWriteFile.writeToTextFile;

public class main_File {
    private static ArrayList<String> referenceData = new ArrayList<String>();
    private static ArrayList<String> scoresData = new ArrayList<String>();
    private static ArrayList<whereIsMyTransport> whereIsMyTransportlist = new ArrayList<whereIsMyTransport>();

    public void run() throws Exception {
        readFromTextFile.inputFiles(referenceData, "reference-data.txt");
        readFromTextFile.inputFiles(scoresData, "scores.txt");
        whereIsMyTransportlist = sortHashMap.createWMT(referenceData, scoresData);
        Collections.sort(whereIsMyTransportlist, new whereIsMyTransportComparator());
        writeToTextFile.writeText(whereIsMyTransportlist, "results.txt");
    }

    public static void main(String[] args) throws Exception {
        main_File obj = new main_File();
        obj.run();
    }
}