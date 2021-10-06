import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    
    @Override
    public int compare(Card c1, Card c2) {
        return c1.compareTo(c2);
    }
}
