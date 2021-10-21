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


    public Combinaison (Hand h){
        this.h = h;
        this.setSuit_table();
        this.setRank_table();
        this.numberOfConsecutiveCards = this.setConsecutiveCards();
        this.score = this.getScoreOfHand();
        this.subscore = this.getSubScoreOfHand();
    }

    //Initialise le tableau des couleurs et le remplit
    private void setSuit_table() {
        int Trefle = 0, Pique = 0, Coeur = 0, Carreau = 0;
        for (Card c: this.h.getCards()) {
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

    //Initialise le tableau des cartes et le remplit
    private void setRank_table() {
        for (Rank rank: Rank.values()) {
            int sum = 0;
            for (Card c: this.h.getCards()) {
                if (c.getRank().equals(rank)){
                   sum++;
                }
            }
            this.Rank_table.add(sum);
        }
    }

    //Initialise le compteur de cartes consécutives afin de voir si on a une suite
    private int setConsecutiveCards(){
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

    ArrayList<Integer> getSuit_table() {
        return Suit_table;
    }

    ArrayList<Integer> getRank_table() {
        return Rank_table;
    }

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

    //Cherche la combinaison la plus grande dans la main
    int getScoreOfHand() {
        return this.isRoyalFlush();
    }

    //Cherche si on a une quinte flush royale
    int isRoyalFlush() {
        return (this.numberOfConsecutiveCards==5 && this.Suit_table.contains(5) && this.h.getCards().stream().anyMatch(card -> card.getForce() == Rank.Ace.getValue())) ? Rankings.RoyalFlush.getValue() : this.isStraightFlush();
    }

    //Cherche si on a une quinte flush
    private int isStraightFlush() {
        return (this.numberOfConsecutiveCards==5 && this.Suit_table.contains(5)) ? Rankings.StraightFlush.getValue() : this.isFourOfAKind();
    }

    //Cherche si on a un carré
    private int isFourOfAKind() {
        return this.Rank_table.contains(4) ? Rankings.FourOfAKind.getValue() : this.isFullHouse();
    }

    //Cherche si on a un full
    private int isFullHouse() {
        return (this.Rank_table.contains(3) && this.Rank_table.contains(2)) ? Rankings.FullHouse.getValue() : this.isFlush();
    }

    //Cherche si on a une couleur
    private int isFlush() {
        return this.Suit_table.contains(5) ? Rankings.Flush.getValue() : this.isStraight();
    }

    //Cherche si on a une suite
    private int isStraight() {
        return this.numberOfConsecutiveCards==5 ? Rankings.Straight.getValue() : this.isThreeOfAKind();
    }

    //Cherche si on a un brelan
    private int isThreeOfAKind() {
        return this.Rank_table.contains(3) ? Rankings.ThreeOfAKind.getValue() : this.isTwoPair();
    }

    //Cherche si on a une double paire
    private int isTwoPair() {
        int count=0;
        for (Integer i: this.Rank_table) {
            if (i == 2) {
                count++;
            }
        }
        return count==2 ? Rankings.TwoPair.getValue() : this.isPair();
    }

    //Cherche si on a une paire
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
        int maxSubscore=0;
        for (int i = 0; i < this.Rank_table.size(); i++) {
            if (this.Rank_table.get(i)==n) {
                maxSubscore = Math.max(maxSubscore,Rank.values()[i].getValue());
            }
        }
        return maxSubscore;
    }

    public int getScore() {
        return score;
    }

    public int getSubscore() {
        return subscore;
    }

    @Override
    public String toString() {
        return "{Suit_table=" + Suit_table + ", Rank_table=" + Rank_table + '}';
    }
}
