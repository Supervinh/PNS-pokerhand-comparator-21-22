package SoloDojo.V2;

import java.util.Comparator;

public class HandComparator implements Comparator<Hand> {

    @Override
    public int compare(Hand h1, Hand h2) {
        return h1.compareTo(h2);
    }
}
