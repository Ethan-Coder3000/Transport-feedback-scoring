import java.util.*;
import whereIsMyTransportPackage.whereIsMyTransport;

public class whereIsMyTransportComparator implements
        Comparator<whereIsMyTransport> {

    @Override
    public int compare(whereIsMyTransport transport1, whereIsMyTransport transport2) {
        if (transport1.calTotScore() < transport2.calTotScore()) {
            return +1;
        } else if (transport1.calTotScore() > transport2.calTotScore()) {
            return -1;
        } else {
            return 0;
        }
    }
}