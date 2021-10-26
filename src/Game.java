import java.util.ArrayList;

/**
 * Classe permettant de gérer le jeu et afficher les gagnants.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Game {
    //rentre les deux mains dans une ArrayList
    private final ArrayList<Hand> hands;
    //Initialise le deck
    public static Deck deck = new Deck();
    //Indique le nombre de joueurs
    public static final int numberOfPlayers = 2;
    //Indique le nombre de cartes par main
    public static final int numberOfCards = 5;
    //Indique si on tire automatiquement les cartes
    public static final boolean automaticCards = false;

    public Game(ArrayList<Hand> hands) {
        this.hands = hands;
    }

    /**
     * Affiche la main gagnante ou égalité
     */
    public void printWinner() {
        this.sortHands();
        Hand winner = this.hands.get(this.hands.size() - 1);
        ArrayList<Hand> winners = new ArrayList<>();
        for (Hand h : this.hands) {
            if (h.compareTo(winner) == 0) {
                winners.add(h);
            }
        }
        if (winners.size() > 1) {
            if (winners.size() == this.hands.size()) {
                System.out.print("All round Draw - ");
            }
            System.out.println("The Winners are: ");
        } else {
            System.out.println("The Winner is: ");
        }
        for (Hand h : winners) {
            System.out.println(h.handScoreAndSubscoreText());
        }
    }

    /**
     * Si on a plusieurs joueurs, affiche le rang de chaque joueur
     */
    public void showRankings() {
        this.sortHands();
        System.out.println("===Rankings===");
        String t;
        for (int i = 1; i < this.hands.size() + 1; i++) {
            switch (i) {
                case 1 -> t = "st";
                case 2 -> t = "nd";
                case 3 -> t = "rd";
                default -> t = "th";
            }
            System.out.println(i + t + ": " + this.hands.get(this.hands.size() - i).getName());
        }
        System.out.println("==============");
    }

    /**
     * Trie les mains, order croissant.
     */
    public void sortHands() {
        this.hands.sort(new HandComparator());
    }

    /**
     * String composé de la liste des joueurs.
     */
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (Hand h : this.hands) {
            msg.append(h).append("\n");
        }
        return msg.toString();
    }
}
