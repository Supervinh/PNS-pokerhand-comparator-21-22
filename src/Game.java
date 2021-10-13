import java.util.ArrayList;

public class Game {
   private final ArrayList<Hand> hands;
   public static Deck deck = new Deck();
   public static final int numberOfPlayers = 5;
   public static final int numberOfCards = 5;
   public static final boolean automaticCards = true;

    public Game(ArrayList<Hand> hands){
        this.hands = hands;
    }

    public void printWinner() {
        this.sortHands();
        Hand winner = this.hands.get(this.hands.size()-1);
        ArrayList<Hand> winners = new ArrayList<>();
        for (Hand h: this.hands) {
            if (h.getScore()==winner.getScore() && h.getSubscore()==winner.getSubscore()) {
                if (winner.getScore()!=0) {
                    winners.add(h);
                }
            }
        }
        if (winners.size()<=1) {
            System.out.println("Le Gagnant est: " + winner);
        }
        else {
            System.out.println("Les Gagnants sont: ");
            for (Hand h: winners) {
                System.out.println(h);
            }
        }
    }

    public void sortHands() {
        this.hands.sort(new HandComparator());
    }

    public String toString(){
        StringBuilder msg = new StringBuilder();
        for (Hand h: this.hands) {
            msg.append(h).append("\n");
        }
        return msg.toString();
    }
}
