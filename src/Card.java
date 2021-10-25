/**
 * Classe permettant de créer des cartes de poker.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Card {
    //Valeur de la carte
    private final Rank rank;
    //Couleur de la carte
    private final Suit suit;
    //Force de la carte
    private final int force;

    public Card(Rank r, Suit s) {
        this.rank = r;
        this.suit = s;
        this.force = this.rank.getValue();
    }

    /**
     * @return Le rang de la carte.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * @return Le symbole de la carte.
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
     * @return un string donnant une carte composée de son rang et de son symbole/couleur
     */
    public String toString() {
        return "[" + this.rank + ", " + this.suit + "]";
    }

    /**
     * Compare la force de deux cartes
     * @param c2 la carte à comparer
     * @return le résultat de la soustraction de la force des deux cartes
     */
    public int compareTo(Card c2) {
        return this.getForce() - c2.getForce();
    }

    /**
     * @return un booléen qui dit si 2 cartes sont identiques
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
