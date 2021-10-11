import java.util.*;

public class Hand {
    private final ArrayList<Card> cards;
    private static int playerNum = 0;
    private String name = "Player ";

    public Hand(ArrayList<Card> cards){
        Hand.playerNum++;
        this.cards = cards;
        this.name += Hand.playerNum;
        this.sortHand(this.cards);
    }

    public void sortHand(ArrayList<Card> cards) {
        cards.sort(new CardComparator());
    }

    public Card highestCard(){
        return this.cards.get(this.cards.size()-1);
    }

    public ArrayList<Card> getCarte() {
        return this.cards;
    }

    public String toString(){
        return this.name + " : " + this.cards;
    }
}
