/**
 * Liste explicite des valeurs possibles associées à leur force
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public enum Rank {
    // Liste explicite de tous les symboles possible avec leur valeur.
    Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13), Ace(14);

    // Variable qui stock la valeur du symbole.
    private final int value;

    /**
     * Constructeur de la class, et initialise les valeurs des symboles.
     *
     * @param value Valeur du symbole.
     */
    Rank(int value) {
        this.value = value;
    }

    /**
     * @return La valeur du symbole.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * @param n Force qu'on cherche.
     * @return L'Enum qui a pour valeur n.
     */
    public static Rank rankFromScore(int n) {
        for (Rank r : Rank.values()) {
            if (r.getValue() == n)
                return r;
        }
        return null;
    }
}