import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        Random rand = new Random();
        for (int i = 0; i < Math.max(10, rand.nextInt(20)); i++) {
            this.shuffleDeck();
        }
    }

    public void shuffleDeck() {
        Random rand = new Random();
        ArrayList<Card> tempDeck = new ArrayList<>();
        while (!this.deck.isEmpty()) {
            tempDeck.add(this.deck.remove(rand.nextInt(this.deck.size())));
        }
        this.deck = tempDeck;
    }

    public Card drawCard() {
        if (!this.deck.isEmpty()) {
            return this.deck.remove(0);
        }
        System.out.println("No more Cards - End of Game.");
        System.exit(0);
        return null;
    }

    public Card takeCard(Card c) {
        if (!this.deck.isEmpty() && this.deck.contains(c)) {
            for (int i = 0; i < this.deck.size(); i++) {
                if (this.deck.get(i).equals(c)) {
                    this.deck.remove(i);
                }
            }
            return c;
        }
        System.out.println(c + " has already been Drawn - Try again.");
        return takeCard(new Card(InputReader.typingRank(), InputReader.typingSuit()));
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        return "Deck " + deck + ", nbCards=" + deck.size();
    }
}
