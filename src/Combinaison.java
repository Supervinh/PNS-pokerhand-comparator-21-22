import java.util.*;

/**
 * Classe permettant de repérer les différentes combinaisons possibles dans une main et d'assigner une force à chaque combinaison.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Combinaison {
    //Variable permettant d'initialiser une main
    private final Hand h;
    //tableau des différentes couleurs possibles afin de repérer une couleur dans une main
    private final ArrayList<Integer> Suit_table = new ArrayList<>();
    //un tableau des différentes cartes possibles afin de repérer les différentes combinaisons
    private final ArrayList<Integer> Rank_table = new ArrayList<>();
    //Permet de détecter si une main possède une suite
    private final int numberOfConsecutiveCards;
    //associe à chaque main un score en fonction des combinaisons qu'elle possède
    private final int score;
    //associe à une main un deuxième score afin de comparer deux mains avec des combinaisons identiques
    private final int subscore;


    public Combinaison(Hand h) {
        this.h = h;
        this.setSuit_table();
        this.setRank_table();
        this.numberOfConsecutiveCards = this.setConsecutiveCards();
        this.score = this.getScoreOfHand();
        this.subscore = this.getSubScoreOfHand();
    }

    /**
     * Remplit le tableau de couleurs des cartes de la main
     */
    private void setSuit_table() {
        int Trefle = 0, Pique = 0, Coeur = 0, Carreau = 0;
        for (Card c : this.h.getCards()) {
            if (c.getSuit().equals(Suit.Trefle)) {
                Trefle++;
            } else if (c.getSuit().equals(Suit.Pique)) {
                Pique++;
            } else if (c.getSuit().equals(Suit.Coeur)) {
                Coeur++;
            } else if (c.getSuit().equals(Suit.Carreau)) {
                Carreau++;
            }
        }
        Collections.addAll(this.Suit_table, Trefle, Pique, Coeur, Carreau);
    }

    /**
     * Remplit le tableau du rang des cartes de la main
     */
    private void setRank_table() {
        for (Rank rank : Rank.values()) {
            int sum = 0;
            for (Card c : this.h.getCards()) {
                if (c.getRank().equals(rank)) {
                    sum++;
                }
            }
            this.Rank_table.add(sum);
        }
    }

    /**
     * Compte les cartes consécutives afin de voir si on a une suite
     * @return le nombre maximum de cartes consécutives dans une main
     */
    private int setConsecutiveCards() {
        int compteur_max = 0, compteur = 0;
        for (Integer integer : this.Rank_table) {
            if (integer != 0) {
                compteur++;
            } else {
                compteur_max = Math.max(compteur, compteur_max);
                compteur = 0;
            }
        }
        return Math.max(compteur, compteur_max);
    }

    /**
     * @return le tableau de couleurs d'une main
     */
    ArrayList<Integer> getSuit_table() {
        return Suit_table;
    }

    /**
     * @return le tableau de rangs d'une main
     */
    ArrayList<Integer> getRank_table() {
        return Rank_table;
    }

    /**
     * @return le nombre maximal de cartes consécutives d'une main
     */
    int getNumberOfConsecutiveCards() {
        return numberOfConsecutiveCards;
    }

    //Associe un score à la main selon les combinaisons qu'elle possède
    public Rankings getHandRanking() {
        for (Rankings rankings : Rankings.values()) {
            if (rankings.getValue() == this.score) {
                return rankings;
            }
        }
        return Rankings.HighCard;
    }

    /**
     * Cherche la plus grande combinaison dans la main
     * @return le résultat de la méthode isRoyalFlush(), à la fin ça retournera un int équivalent à la valeur de la plus grande combinaison trouvée
     */
    int getScoreOfHand() {
        return this.isRoyalFlush();
    }

    /**
     * Cherche si on a une quinte flush royale
     * @return le score de la combinaison cherchée sinon appelle isStraightFlush()
     */
    int isRoyalFlush() {
        return (this.numberOfConsecutiveCards == 5 && this.Suit_table.contains(5) && this.h.getCards().stream().anyMatch(card -> card.getForce() == Rank.Ace.getValue())) ? Rankings.RoyalFlush.getValue() : this.isStraightFlush();
    }

    /**
     * Cherche si on a une quinte flush
     * @return le score de la combinaison cherchée sinon appelle isFourOfAKind()
     */
    int isStraightFlush() {
        return (this.numberOfConsecutiveCards == 5 && this.Suit_table.contains(5)) ? Rankings.StraightFlush.getValue() : this.isFourOfAKind();
    }

    /**
     * Cherche si on a un carré
     * @return le score de la combinaison cherchée sinon appelle isFullHouse()
     */
    int isFourOfAKind() {
        return this.Rank_table.contains(4) ? Rankings.FourOfAKind.getValue() : this.isFullHouse();
    }

    /**
     * Cherche si on a un full
     * @return le score de la combinaison cherchée sinon appelle isFlush()
     */
    int isFullHouse() {
        return (this.Rank_table.contains(3) && this.Rank_table.contains(2)) ? Rankings.FullHouse.getValue() : this.isFlush();
    }

    /**
     * Cherche si on a une couleur
     * @return le score de la combinaison cherchée sinon appelle isStraight()
     */
    int isFlush() {
        return this.Suit_table.contains(5) ? Rankings.Flush.getValue() : this.isStraight();
    }

    /**
     * Cherche si on a une suite
     * @return le score de la combinaison cherchée sinon appelle isThreeOfAKind()
     */
    int isStraight() {
        return this.numberOfConsecutiveCards == 5 ? Rankings.Straight.getValue() : this.isThreeOfAKind();
    }

    /**
     * Cherche si on a un brelan
     * @return le score de la combinaison cherchée sinon appelle isTwoPair()
     */
    int isThreeOfAKind() {
        return this.Rank_table.contains(3) ? Rankings.ThreeOfAKind.getValue() : this.isTwoPair();
    }

    /**
     * Cherche si on a deux paires
     * @return le score de la combinaison cherchée sinon appelle isPair()
     */
    int isTwoPair() {
        int count = 0;
        for (Integer i : this.Rank_table) {
            if (i == 2) {
                count++;
            }
        }
        return count == 2 ? Rankings.TwoPair.getValue() : this.isPair();
    }

    /**
     * Cherche si on a une paire
     * @return le score de la combinaison cherchée sinon 1
     */
    int isPair() {
        return this.Rank_table.contains(2) ? Rankings.Pair.getValue() : Rankings.HighCard.getValue();
    }

    //Associe un score à la main en fonction des combinaisons qu'elle possède
    private int getSubScoreOfHand() {
        return switch (this.getScoreOfHand()) {
            case 10 -> Rank.Ace.getValue();
            case 9, 6, 5, 1 -> this.subScoreOfHighCard();
            case 8 -> this.subscoreMethodN(4);
            case 7, 4 -> this.subscoreMethodN(3);
            case 3, 2 -> this.subscoreMethodN(2);
            default -> 0;
        };
    }

    //Associe à la main un deuxième score selon sa carte dominante afin de départager deux mains de combinaisons identiques
    private int subScoreOfHighCard() {
        return this.h.highestCard(this.h.getCards()).getForce();
    }

    // ???????????????????????????
    private int subscoreMethodN(int n) {
        int maxSubscore = 0;
        for (int i = 0; i < this.Rank_table.size(); i++) {
            if (this.Rank_table.get(i) == n) {
                maxSubscore = Math.max(maxSubscore, Rank.values()[i].getValue());
            }
        }
        return maxSubscore;
    }

    /**
     * @return le score de la main
     */
    public int getScore() {
        return score;
    }

    /**
     * @return le subscore de la main
     */
    public int getSubscore() {
        return subscore;
    }

    /**
     * @return un string donnant le tableau de couleurs et le tableau de rangs
     */
    @Override
    public String toString() {
        return "{Suit_table=" + Suit_table + ", Rank_table=" + Rank_table + '}';
    }
}
