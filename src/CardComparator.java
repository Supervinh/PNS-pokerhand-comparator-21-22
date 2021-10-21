import java.util.Comparator;

/**
 * Classe comparant 2 cartes entre elles
 *
 * @Author Matis Herrmann
 * @Author Louis Hattiger
 * @Author Vinh Faucher
*/

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.compareTo(o2);
    }
}
