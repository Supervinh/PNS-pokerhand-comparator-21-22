import java.util.ArrayList;
import java.util.Optional;

public class Game {
   private ArrayList<Hand> hands;
   public static final int numberOfPlayers = 2;
   public static final int numberOfCards = 2;

    public Game(ArrayList<Hand> hands){
        this.hands = hands;
    }

    public Optional<Hand> compete(){
//  This is Tempory
        Hand hand1 = this.hands.get(0), hand2 = this.hands.get(1);
        if (hand1.highestCard().getValeur() < hand2.highestCard().getValeur()){
            return Optional.ofNullable(hand2);
        }
        else if (hand1.highestCard().getValeur() > hand2.highestCard().getValeur()){
            return Optional.ofNullable(hand1);
        }
        return Optional.empty();
    }

    public String toString(){
        return this.hands.get(0).toString();
    }
}
