import java.util.Comparator;

public class HandComparator implements Comparator<Hand> {
    @Override
    public int compare(Hand o1, Hand o2) {
        return o1.compareTo(o2);
    }
}
