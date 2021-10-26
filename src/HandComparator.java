import java.util.Comparator;

/**
 * Classe permettant de comparer deux mains de poker, utilisé pour les Collections.sort().
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class HandComparator implements Comparator<Hand> {
    @Override
    public int compare(Hand o1, Hand o2) {
        return o1.compareTo(o2);
    }
}
