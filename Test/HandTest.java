import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;

class HandTest {
    private Card[] c1 = new Card[]{new Card(Rank.Deux, Suit.Carreau), new Card(Rank.Six, Suit.Carreau), new Card(Rank.Trois, Suit.Carreau), new Card(Rank.Quatre, Suit.Carreau), new Card(Rank.Cinq, Suit.Carreau)};
    private Card[] c2 = new Card[]{new Card(Rank.As, Suit.Coeur), new Card(Rank.Sept, Suit.Pique), new Card(Rank.Valet, Suit.Trefle), new Card(Rank.Huit, Suit.Coeur), new Card(Rank.As, Suit.Trefle)};

    private ArrayList<Card> C1 = new ArrayList<>();
    private ArrayList<Card> C2 = new ArrayList<>();
    private Hand h1;
    private Hand h2;

    @BeforeEach
    void setUp() {
        Collections.addAll(C1, this.c1);
        Collections.addAll(C2, this.c2);
        h1 = new Hand(C1);
        h2 = new Hand(C2);
    }

    @Test
    void TestHighestCard() {
        Assertions.assertEquals(h1.highestCard(h1.getCards()), new Card(Rank.Six, Suit.Carreau));
        Assertions.assertEquals(h2.highestCard(h2.getCards()), new Card(Rank.As, Suit.Trefle) );
    }
}