package Test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import whereIsMyTransportPackage.whereIsMyTransport;
// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;

public class JunitTestWhereIsMyTransport {
    public String agency = "Agency 1";
    public Map<String, Double> ideni = new HashMap<>();
    public Map<String, Integer> count = new HashMap<>();
    public String route_identifiers = "iden-123";

    @Before
    public void createMap() {
        ideni.put("Monday", 50.3);
        ideni.put("tuesday", 20.5);
        ideni.put("wednesday ", 45.3);
        ideni.put("thursday", 34.3);
        ideni.put("friday", 85.3);
        ideni.put("saturday", 90.3);
        ideni.put("sunday", 25.3);
        count.put("Monday", 13);
        count.put("tuesday", 2);
        count.put("wednesday ", 49);
        count.put("thursday", 24);
        count.put("friday", 18);
        count.put("saturday", 12);
        count.put("sunday", 5);
    }

    @Test
    public void testSortHash() {
        whereIsMyTransport transport = new whereIsMyTransport(agency, route_identifiers, ideni, count);
        transport.sortHash();
        String out = "Agency 1 saturday 90.3\nAgency 1 friday 85.3\nAgency 1 Monday 50.3\nAgency 1 wednesday  45.3\nAgency 1 thursday 34.3\nAgency 1 sunday 25.3\nAgency 1 tuesday 20.5\n";
        assertEquals(transport.toString(), out);
        System.out.println("Test 1: Success");
    }

    @Test
    public void testPerformCalc() {
        whereIsMyTransport transport = new whereIsMyTransport(agency, route_identifiers, ideni, count);
        transport.performCalc();
        String out = "Agency 1 tuesday 10.25\nAgency 1 saturday 7.52\nAgency 1 sunday 5.06\nAgency 1 friday 4.74\nAgency 1 Monday 3.87\nAgency 1 thursday 1.43\nAgency 1 wednesday  0.92\n";
        assertEquals(transport.toString(), out);
        System.out.println("Test 2: Success");
    }

    @Test
    public void testCalcTotScore() {
        whereIsMyTransport transport = new whereIsMyTransport(agency, route_identifiers, ideni, count);
        Double out = 351.3;
        assertEquals(transport.calTotScore(), out);
        System.out.println("Test 3: Success");
    }

    @Test
    public void testGetDay() throws Exception {
        whereIsMyTransport transport = new whereIsMyTransport(agency, route_identifiers, ideni, count);
        String day1 = "Saturday";
        String day2 = "Tuesday";
        String day3 = "Friday";
        String day4 = "Monday";
        String day5 = "Wednesday";
        assertEquals(transport.getDay("2020/04/18"), day1);
        assertEquals(transport.getDay("2021/05/04"), day2);
        assertEquals(transport.getDay("2022/04/15"), day3);
        assertEquals(transport.getDay("2021/05/17"), day4);
        assertEquals(transport.getDay("2018/01/24"), day5);
        System.out.println("Test 4: Success");
    }

}
