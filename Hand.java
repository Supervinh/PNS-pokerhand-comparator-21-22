package SoloDojo.Slices;

import java.util.ArrayList;

public class Hand {
    private static int playerNumber = 0;
    private String playerName = "Player ";
    private ArrayList<Card> cards;
    
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
        Hand.playerNumber++;
        this.playerName += Hand.playerNumber;
    }

    @Override   
    public String toString() {
        return this.playerName + " " + this.cards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
