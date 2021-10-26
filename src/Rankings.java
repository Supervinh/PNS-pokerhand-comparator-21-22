/**
 * Liste explicite des combinaisons possibles associées à une valeur
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public enum Rankings {
    // Liste explicite de toutes les combinaisons possible avec leur valeur.
    RoyalFlush(10), StraightFlush(9), FourOfAKind(8), FullHouse(7), Flush(6), Straight(5), ThreeOfAKind(4), TwoPair(3), Pair(2), HighCard(1);

    // Variable qui stock la valeur de la combinaison.
    private final int value;

    /**
     * Constructeur de la class, et initialise les valeurs des combinaisons.
     *
     * @param v Valeur de la combinaison.
     */
    Rankings(int v) {
        this.value = v;
    }

    /**
     * @return La valeur de la combinaison.
     */
    public int getValue() {
        return value;
    }
}
