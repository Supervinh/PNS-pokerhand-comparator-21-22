/**
 * Classe permettant de créer des cartes de poker.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Card {
    // Valeur de la carte.
    private final Rank rank;

    // Couleur de la carte.
    private final Suit suit;

    // Force de la carte.
    private final int force;

    /**
     * Constructeur de la classe. Initialise la force de la carte.
     *
     * @param r Le symbole de la carte.
     * @param s La couleur de la carte.
     */
    public Card(Rank r, Suit s) {
        this.rank = r;
        this.suit = s;
        this.force = this.rank.getValue();
    }

    /**
     * @return Le symbole de la carte.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * @return Le couleur de la carte.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * @return La force de la carte attribuée au rang.
     */
    public int getForce() {
        return this.force;
    }

    /**
     * @return un string donnant une carte composée de son symbole et de sa couleur.
     */
    public String toString() {
        return "[" + this.rank + ", " + this.suit + "]";
    }

    /**
     * Compare la force de deux cartes.
     *
     * @param c2 La carte à comparer.
     * @return La différence de force entre les deux cartes.
     */
    public int compareTo(Card c2) {
        return this.getForce() - c2.getForce();
    }

    /**
     * @param obj Un autre object avec qui on veut comparer.
     * @return un booléen qui dit si deux cartes sont identiques.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        return suit == other.suit;
    }
}
