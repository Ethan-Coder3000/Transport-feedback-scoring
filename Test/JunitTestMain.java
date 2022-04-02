package Test;

import static org.junit.Assert.assertEquals;

import java.util.*;
import org.junit.Before;
import org.junit.Test;
import whereIsMyTransportPackage.whereIsMyTransport;
import src.sortHashMap;
import comparatorPackage.whereIsMyTransportComparator;

public class JunitTestMain {
    public ArrayList<String> referenceData = new ArrayList<String>();
    public ArrayList<String> scoresData = new ArrayList<String>();
    public ArrayList<whereIsMyTransport> whereIsMyTransportlist = new ArrayList<whereIsMyTransport>();

    @Before
    public void defineArrayList() {
        referenceData.add("route_f97ad4ff UNI;Rome - Milan");
        referenceData.add("route_cc4722b0 UNI;Milan - Tasqueña");
        referenceData.add("route_29eac9a5 UNI;Milan - Palermo");
        referenceData.add("route_66d0f0b7 UNI;Palermo - Florence");
        referenceData.add("route_ad8944a4 UNI;Garibaldi - Veniceión de 1758");
        scoresData.add("2021/11/14;route_f97ad4ff 7");
        scoresData.add("2021/11/10;route_cc4722b0 2");
        scoresData.add("2021/11/11;route_29eac9a5 3");
        scoresData.add("2021/11/16;route_66d0f0b7 2");
        scoresData.add("2021/11/18;route_ad8944a4 6");
        scoresData.add("2021/11/24;route_f97ad4ff 9");
        scoresData.add("2021/11/08;route_cc4722b0 4");
        scoresData.add("2021/11/13;route_29eac9a5 8");
        scoresData.add("2021/11/14;route_66d0f0b7 0");
        scoresData.add("2021/11/16;route_ad8944a4 5");
        scoresData.add("2021/11/14;route_f97ad4ff 2");
        scoresData.add("2021/11/10;route_66d0f0b7 6");
        scoresData.add("2021/11/11;route_ad8944a4 7");
        scoresData.add("2021/11/05;route_f97ad4ff 8");
        scoresData.add("2021/11/10;route_cc4722b0 6");
        scoresData.add("2021/11/15;route_29eac9a5 10");
        scoresData.add("2021/11/19;route_66d0f0b7 8");

        scoresData.add("2021/11/21;route_f97ad4ff 2");
        scoresData.add("2021/11/17;route_cc4722b0 2");
        scoresData.add("2021/11/18;route_29eac9a5 3");
        scoresData.add("2021/11/23;route_66d0f0b7 2");
        scoresData.add("2021/11/25;route_ad8944a4 2");
        scoresData.add("2021/11/17;route_f97ad4ff 2");
        scoresData.add("2021/11/15;route_cc4722b0 2");
        scoresData.add("2021/11/20;route_29eac9a5 2");
        scoresData.add("2021/11/21;route_66d0f0b7 2");
        scoresData.add("2021/11/23;route_ad8944a4 2");
        scoresData.add("2021/11/21;route_f97ad4ff 2");
        scoresData.add("2021/11/17;route_66d0f0b7 2");
        scoresData.add("2021/11/18;route_ad8944a4 0");
        scoresData.add("2021/11/15;route_f97ad4ff 2");
        scoresData.add("2021/11/17;route_cc4722b0 2");
        scoresData.add("2021/11/22;route_29eac9a5 2");
        scoresData.add("2021/11/26;route_66d0f0b7 2");
    }

    @Test
    public void testList() throws Exception {
        whereIsMyTransportlist = sortHashMap.createWMT(referenceData, scoresData);
        String out = "Rome - Milan Friday 8.0\nRome - Milan Wednesday 5.5\nRome - Milan Sunday 3.25\nRome - Milan Monday 2.0\n";
        String out1 = "Milan - Tasqueña Monday 3.0\nMilan - Tasqueña Wednesday 3.0\n";
        String out2 = "Milan - Palermo Saturday 5.0\nMilan - Palermo Thursday 3.0\nMilan - Palermo Monday 2.0\n";
        String out3 = "Palermo - Florence Friday 5.0\nPalermo - Florence Wednesday 4.0\nPalermo - Florence Sunday 2.0\nPalermo - Florence Tuesday 2.0\n";
        String out4 = "Garibaldi - Veniceión de 1758 Thursday 5.0\nGaribaldi - Veniceión de 1758 Tuesday 3.5\n";
        assertEquals(whereIsMyTransportlist.get(0).toString(), out);
        assertEquals(whereIsMyTransportlist.get(1).toString(), out1);
        assertEquals(whereIsMyTransportlist.get(2).toString(), out2);
        assertEquals(whereIsMyTransportlist.get(3).toString(), out3);
        assertEquals(whereIsMyTransportlist.get(4).toString(), out4);
        System.out.println("Test 1: Success");
    }

    @Test
    public void testSort() throws Exception {
        whereIsMyTransportlist = sortHashMap.createWMT(referenceData, scoresData);
        Collections.sort(whereIsMyTransportlist, new whereIsMyTransportComparator());
        String out = "Rome - Milan Friday 8.0\nRome - Milan Wednesday 5.5\nRome - Milan Sunday 3.25\nRome - Milan Monday 2.0\n";
        String out1 = "Palermo - Florence Friday 5.0\nPalermo - Florence Wednesday 4.0\nPalermo - Florence Sunday 2.0\nPalermo - Florence Tuesday 2.0\n";
        String out2 = "Milan - Palermo Saturday 5.0\nMilan - Palermo Thursday 3.0\nMilan - Palermo Monday 2.0\n";
        String out3 = "Garibaldi - Veniceión de 1758 Thursday 5.0\nGaribaldi - Veniceión de 1758 Tuesday 3.5\n";
        String out4 = "Milan - Tasqueña Monday 3.0\nMilan - Tasqueña Wednesday 3.0\n";
        assertEquals(whereIsMyTransportlist.get(0).toString(), out);
        assertEquals(whereIsMyTransportlist.get(1).toString(), out1);
        assertEquals(whereIsMyTransportlist.get(2).toString(), out2);
        assertEquals(whereIsMyTransportlist.get(3).toString(), out3);
        assertEquals(whereIsMyTransportlist.get(4).toString(), out4);
        System.out.println("Test 2: Success");
    }

}
