package SoloDojo.Slices.Slice_1;

public class Hand {
    private static int playerNumber = 0;
    private String playerName = "Player ";
    private Card card;
    
    public Hand(Card card) {
        this.card = card;
        Hand.playerNumber++;
        this.playerName += Hand.playerNumber;
    }

    @Override
    public String toString() {
        return this.playerName + " " + card;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Card getCard() {
        return card;
    }
}
