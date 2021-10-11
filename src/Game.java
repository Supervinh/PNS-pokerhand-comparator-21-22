import java.util.ArrayList;
import java.util.Optional;

public class Game {
   private final ArrayList<Hand> hands;
   public static final int numberOfPlayers = 5;
   public static final int numberOfCards = 5;
   public static final boolean automaticCards = true;
   public static Deck deck = new Deck();

    public Game(ArrayList<Hand> hands){
        this.hands = hands;
    }

    public Optional<Hand> compete(){
//  This is Tempory
        Hand hand1 = this.hands.get(0), hand2 = this.hands.get(1);
        if (hand1.highestCard().getForce() < hand2.highestCard().getForce()){
            return Optional.ofNullable(hand2);
        }
        else if (hand1.highestCard().getForce() > hand2.highestCard().getForce()){
            return Optional.ofNullable(hand1);
        }
        return Optional.empty();
    }

    public String toString(){
        String msg = "";
        for (Hand h: this.hands) {
            msg += h + "\n";
        }
        return msg;
    }
}
