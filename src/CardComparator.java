import java.util.Comparator;

/**
 * Classe permettant de comparer les cartes de poker, utilisé pour les Collections.sort().
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.compareTo(o2);
    }
}
