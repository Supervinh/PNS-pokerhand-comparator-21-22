package SoloDojo.Slices;

import java.util.ArrayList;

public class Game {
    public static int numberofPlayers;
    public static int numberofCards;
    private ArrayList<Hand> hands = new ArrayList<>();

    public Game(int nbp, int nbc) {
        numberofPlayers = nbp;
        numberofCards = nbc;
    }


    public void showHands() {
        for (Hand hand : this.hands) {
            System.out.println(hand);
        }
    }

    @Override
    public String toString() {
        return ResultPrinter.getResult(this.hands.get(0));
    }
    
    public ArrayList<Hand> getHands() {
        return hands;
    }
        
}
