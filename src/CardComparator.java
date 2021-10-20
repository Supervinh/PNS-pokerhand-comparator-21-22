/*Classe comparant 2 cartes entre elles
* @author Matis
* @author Louis
* @author Vinh Faucher
*/
import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.compareTo(o2);
    }
}
