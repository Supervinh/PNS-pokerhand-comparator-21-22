/* Tests sur la classe Deck
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 * */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;


class DeckTest {
    private Deck deck;
    private Card card1;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    public void TestTakeCard(){
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                card1 = new Card(rank, suit);
                Assertions.assertEquals(card1, deck.takeCard(card1));
            }
        }
    }

    @Test
    public void TestDrawCard(){
        while (deck.getDeck().size() != 0) {
            Assertions.assertEquals(deck.getDeck().get(0), deck.drawCard());
        }
    }

    @Test
    public void TestShuffleDeck(){
        ArrayList<Card> base_deck = deck.getDeck();
        deck.shuffleDeck();
        Assertions.assertNotEquals(base_deck, deck.getDeck());
    }
}