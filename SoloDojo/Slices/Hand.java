package SoloDojo.Slices;

import java.util.ArrayList;

public class Hand {
    private static int playerNumber = 0;
    private String playerName = "Player ";
    private ArrayList<Card> cards = new ArrayList<>();
    
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
        Hand.playerNumber++;
        this.playerName += Hand.playerNumber;
    }

    public void sortHand() {
        this.cards.sort(new CardComparator());
    }

    @Override   
    public String toString() {
        return this.playerName + " - " + this.cards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public int compareTo(Hand h2) {
        // A Faire
        return 0;
    }
}
