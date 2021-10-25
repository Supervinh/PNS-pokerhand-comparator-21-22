import java.util.*;

/**
 * Classe permettant de créer les mains de poker
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Hand {
    // Le numéro du joueur
    private static int playerNum = 0;
    // Le nom du joueur
    private String name = "Player ";
    // La main de Poker
    private final ArrayList<Card> cards;
    // La valeur de la combinaison que possède la main
    private final Combinaison C;
    // Le score associé à la combinaison
    private final int score;
    // Le score associé à la carte dominante
    private final int subscore;

    public Hand(ArrayList<Card> cards) {
        Hand.playerNum++;
        this.name += Hand.playerNum;
        this.cards = cards;
        this.sortHand(this.cards);
        this.C = new Combinaison(this);
        this.score = this.C.getScore();
        this.subscore = this.C.getSubscore();
    }


    public Card highestCard(ArrayList<Card> cards) {
        return cards.get(cards.size() - 1);
    }

    /**
     * @return Les cartes de la main.
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * @return Le score de la main.
     */
    public int getScore() {
        return score;
    }

    /**
     * @return Le subscore de la main.
     */
    public int getSubscore() {
        return subscore;
    }

    /**
     * @return Le nom de la main.
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + ": " + this.cards + " \u25B6 " + this.C.getHandRanking();
    }

    public String handScoreAndSubscoreText() {
        return this.getName() + " with a " + this.C.getHandRanking() + ": " + Rank.rankFromScore(this.subscore);
    }

    public int compareTo(Hand h) {
        int dif = this.score - h.score;
        if (dif == 0) {
            dif = this.subscore - h.subscore;
            if (dif == 0) {
                ArrayList<Card> c1 = (ArrayList<Card>) this.getCards().clone();
                ArrayList<Card> c2 = (ArrayList<Card>) h.getCards().clone();
                switch (this.score) {
                    case 3 -> dif = this.methodTwoPair(h, c1, c2);
                    case 2 -> dif = this.methodPair(h, c1, c2);
                    default -> dif = this.methodHighestCard(h, c1, c2);
                }
            }
        }
        return dif;
    }

    public int methodTwoPair(Hand h, ArrayList<Card> c1, ArrayList<Card> c2) {
        c1.removeIf(card -> card.getForce() == this.subscore);
        c2.removeIf(card -> card.getForce() == h.subscore);
        Hand h1 = new Hand(c1);
        Hand h2 = new Hand(c2);
        int dif = h1.subscore - h2.subscore;
        if (dif == 0) {
            c1.removeIf(card -> card.getForce() == h1.subscore);
            c2.removeIf(card -> card.getForce() == h2.subscore);
            dif = this.methodHighestCard(h, c1, c2);
        }
        return dif;
    }

    public int methodPair(Hand h, ArrayList<Card> c1, ArrayList<Card> c2) {
        c1.removeIf(card -> card.getForce() == this.subscore);
        c2.removeIf(card -> card.getForce() == h.subscore);
        return this.methodHighestCard(h, c1, c2);
    }

    public int methodHighestCard(Hand h, ArrayList<Card> c1, ArrayList<Card> c2) {
        int dif = 0;
        while (!c1.isEmpty() && !c2.isEmpty() && dif == 0) {
            dif = this.highestCard(c1).getForce() - h.highestCard(c2).getForce();
            c1.remove(c1.size() - 1);
            c2.remove(c2.size() - 1);
        }
        return dif;
    }

    public void sortHand(ArrayList<Card> cards) {
        cards.sort(new CardComparator());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
