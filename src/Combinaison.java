import java.util.*;

/**
 * Classe permettant de repérer les différentes combinaisons possibles dans une main et d'assigner une force à chaque combinaison, et une sous force en cas de différenciation.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Combinaison {
    // Variable permettant de stocker une main
    private final Hand h;

    // Tableau d'occurrence des différentes couleurs.
    private final ArrayList<Integer> Suit_table = new ArrayList<>();

    // Un tableau d'occurrence des différentes cartes.
    private final ArrayList<Integer> Rank_table = new ArrayList<>();

    // Variable qui stock le nombre de cartes consécutif dans la main.
    private final int numberOfConsecutiveCards;

    // Variable qui stock le score de la main en fonction des combinaisons qu'elle possède.
    private final int score;

    // Variable qui stock un deuxième score afin de comparer deux mains avec une combinaison identique.
    private final int subscore;

    /**
     * Constructeur de cette classe, puis initialiser les tableaux d'occurrences, ainsi que le nombre de carte
     * consécutif et finir par attribuer un score et un sous score en fonction de la combinaison trouvé.
     *
     * @param h La carte qu'on veut connaître sa combinaison.
     */
    public Combinaison(Hand h) {
        this.h = h;
        this.setSuit_table();
        this.setRank_table();
        this.numberOfConsecutiveCards = this.setConsecutiveCards();
        this.score = this.getScoreOfHand();
        this.subscore = this.getSubScoreOfHand();
    }

    /**
     * Remplit le tableau de couleurs des cartes de la main.
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
     * Remplit le tableau du rang des cartes de la main.
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
     * Compte les cartes consécutives maximum.
     *
     * @return le nombre maximum de cartes consécutives dans une main.
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
     * @return le tableau d'occurrence de couleurs d'une main.
     */
    public ArrayList<Integer> getSuit_table() {
        return Suit_table;
    }

    /**
     * @return le tableau d'occurrence de rangs d'une main.
     */
    public ArrayList<Integer> getRank_table() {
        return Rank_table;
    }

    /**
     * @return le nombre maximal de cartes consécutives d'une main.
     */
    public int getNumberOfConsecutiveCards() {
        return numberOfConsecutiveCards;
    }


    /**
     * En parcourant la liste des énumérations de Rankings on cherche celui qui as la même force que le score obtenue.
     *
     * @return Le type de combinaison de l'énumération.
     */
    public Rankings getHandRanking() {
        for (Rankings rankings : Rankings.values()) {
            if (rankings.getValue() == this.score) {
                return rankings;
            }
        }
        return Rankings.HighCard;
    }

    /**
     * Cherche la plus grande combinaison dans de la main.
     *
     * @return le résultat de la méthode isRoyalFlush(), à la fin ça retournera un int équivalent à la valeur de la
     * plus grande combinaison trouvée.
     */
    public int getScoreOfHand() {
        return this.isRoyalFlush();
    }

    /**
     * Cherche si on a une quinte flush royale.
     *
     * @return le score de la combinaison cherchée sinon appelle isStraightFlush().
     */
    public int isRoyalFlush() {
        return (this.numberOfConsecutiveCards == 5 && this.Suit_table.contains(5) &&
                this.h.getCards().stream().anyMatch(card -> card.getForce() == Rank.Ace.getValue())) ? Rankings.RoyalFlush.getValue() : this.isStraightFlush();
    }

    /**
     * Cherche si on a une quinte flush.
     *
     * @return le score de la combinaison cherchée sinon appelle isFourOfAKind().
     */
    public int isStraightFlush() {
        return (this.numberOfConsecutiveCards == 5 && this.Suit_table.contains(5)) ? Rankings.StraightFlush.getValue() : this.isFourOfAKind();
    }

    /**
     * Cherche si on a un carré.
     *
     * @return le score de la combinaison cherchée sinon appelle isFullHouse().
     */
    public int isFourOfAKind() {
        return this.Rank_table.contains(4) ? Rankings.FourOfAKind.getValue() : this.isFullHouse();
    }

    /**
     * Cherche si on a un full.
     *
     * @return le score de la combinaison cherchée sinon appelle isFlush().
     */
    public int isFullHouse() {
        return (this.Rank_table.contains(3) && this.Rank_table.contains(2)) ? Rankings.FullHouse.getValue() : this.isFlush();
    }

    /**
     * Cherche si on a une couleur.
     *
     * @return le score de la combinaison cherchée sinon appelle isStraight().
     */
    public int isFlush() {
        return this.Suit_table.contains(5) ? Rankings.Flush.getValue() : this.isStraight();
    }

    /**
     * Cherche si on a une suite.
     *
     * @return le score de la combinaison cherchée sinon appelle isThreeOfAKind().
     */
    public int isStraight() {
        return this.numberOfConsecutiveCards == 5 ? Rankings.Straight.getValue() : this.isThreeOfAKind();
    }

    /**
     * Cherche si on a un brelan.
     *
     * @return le score de la combinaison cherchée sinon appelle isTwoPair().
     */
    public int isThreeOfAKind() {
        return this.Rank_table.contains(3) ? Rankings.ThreeOfAKind.getValue() : this.isTwoPair();
    }

    /**
     * Cherche si on a deux paires.
     *
     * @return le score de la combinaison cherchée sinon appelle isPair().
     */
    public int isTwoPair() {
        int count = 0;
        for (Integer i : this.Rank_table) {
            if (i == 2) {
                count++;
            }
        }
        return count == 2 ? Rankings.TwoPair.getValue() : this.isPair();
    }

    /**
     * Cherche si on a une paire.
     *
     * @return le score de la combinaison cherchée sinon score de Rankings.HighCard.
     */
    public int isPair() {
        return this.Rank_table.contains(2) ? Rankings.Pair.getValue() : Rankings.HighCard.getValue();
    }

    /**
     * Suivant le score de la main on utilise des méthodes différents pour calculer son sous score.
     *
     * @return Le sous score de la main.
     */
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

    /**
     * Method de calcule du sous score pour les mains qui nécessite de comparer les cartes un à un (Quinte/Couleur/Suite etc...).
     *
     * @return La force de la carte la plus puissante de la main.
     */
    private int subScoreOfHighCard() {
        return this.h.highestCard(this.h.getCards()).getForce();
    }

    /**
     * Method de calcule du sous score pour les mains composée de cartes de force identiques (Pair/Brelan/Carré etc...).
     *
     * @return La force de la carte qui appartient à une collections de cartes identiques.
     */
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
     * @return Le score de la main.
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
