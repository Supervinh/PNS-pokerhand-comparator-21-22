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
        ArrayList<Hand> listWinners = new ArrayList<>();
        //Add Winners to list.
        System.out.println("Le Gagnant est: " + this.hands.get(this.hands.size()-1));
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
