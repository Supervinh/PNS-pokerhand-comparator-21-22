import org.junit.jupiter.api.*;
import java.util.*;

class HandTest {
    private final Card[] c1 = new Card[]{new Card(Rank.Deux, Suit.Pique), new Card(Rank.Neuf, Suit.Trefle), new Card(Rank.Trois, Suit.Carreau), new Card(Rank.Valet, Suit.Carreau), new Card(Rank.Cinq, Suit.Carreau)};
    private final Card[] c2 = new Card[]{new Card(Rank.As, Suit.Coeur), new Card(Rank.Sept, Suit.Pique), new Card(Rank.Valet, Suit.Trefle), new Card(Rank.Huit, Suit.Coeur), new Card(Rank.As, Suit.Trefle)};
    private final Card[] c3 = new Card[]{new Card(Rank.As, Suit.Coeur), new Card(Rank.Sept, Suit.Pique), new Card(Rank.Huit, Suit.Trefle), new Card(Rank.Huit, Suit.Coeur), new Card(Rank.As, Suit.Trefle)};
    private final Card[] c4 = new Card[]{new Card(Rank.As, Suit.Coeur), new Card(Rank.Sept, Suit.Pique), new Card(Rank.As, Suit.Pique), new Card(Rank.Huit, Suit.Coeur), new Card(Rank.As, Suit.Trefle)};
    private final Card[] c5 = new Card[]{new Card(Rank.Trois, Suit.Coeur), new Card(Rank.Sept, Suit.Pique), new Card(Rank.Quatre, Suit.Pique), new Card(Rank.Six, Suit.Coeur), new Card(Rank.Cinq, Suit.Trefle)};
    private final Card[] c6 = new Card[]{new Card(Rank.Trois, Suit.Pique), new Card(Rank.Roi, Suit.Pique), new Card(Rank.Valet, Suit.Pique), new Card(Rank.Six, Suit.Pique), new Card(Rank.Neuf, Suit.Pique)};
    private final Card[] c7 = new Card[]{new Card(Rank.Quatre, Suit.Coeur), new Card(Rank.Cinq, Suit.Pique), new Card(Rank.Quatre, Suit.Pique), new Card(Rank.Cinq, Suit.Coeur), new Card(Rank.Cinq, Suit.Trefle)};
    private final Card[] c8 = new Card[]{new Card(Rank.Deux, Suit.Coeur), new Card(Rank.Cinq, Suit.Pique), new Card(Rank.Cinq, Suit.Carreau), new Card(Rank.Cinq, Suit.Coeur), new Card(Rank.Cinq, Suit.Trefle)};
    private final Card[] c9 = new Card[]{new Card(Rank.Trois, Suit.Coeur), new Card(Rank.Sept, Suit.Coeur), new Card(Rank.Quatre, Suit.Coeur), new Card(Rank.Six, Suit.Coeur), new Card(Rank.Cinq, Suit.Coeur)};
    private final Card[] c10 = new Card[]{new Card(Rank.Roi, Suit.Coeur), new Card(Rank.Dame, Suit.Coeur), new Card(Rank.As, Suit.Coeur), new Card(Rank.Valet, Suit.Coeur), new Card(Rank.Dix, Suit.Coeur)};
    private final ArrayList<Card> C1 = new ArrayList<>();
    private final ArrayList<Card> C2 = new ArrayList<>();
    private final ArrayList<Card> C3 = new ArrayList<>();
    private final ArrayList<Card> C4 = new ArrayList<>();
    private final ArrayList<Card> C5 = new ArrayList<>();
    private final ArrayList<Card> C6 = new ArrayList<>();
    private final ArrayList<Card> C7 = new ArrayList<>();
    private final ArrayList<Card> C8 = new ArrayList<>();
    private final ArrayList<Card> C9 = new ArrayList<>();
    private final ArrayList<Card> C10 = new ArrayList<>();
    private Hand h1;
    private Hand h2;
    private Hand h3;
    private Hand h4;
    private Hand h5;
    private Hand h6;
    private Hand h7;
    private Hand h8;
    private Hand h9;
    private Hand h10;
    private final ArrayList<Hand> hands = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Collections.addAll(C1, this.c1);
        Collections.addAll(C2, this.c2);
        Collections.addAll(C3, this.c3);
        Collections.addAll(C4, this.c4);
        Collections.addAll(C5, this.c5);
        Collections.addAll(C6, this.c6);
        Collections.addAll(C7, this.c7);
        Collections.addAll(C8, this.c8);
        Collections.addAll(C9, this.c9);
        Collections.addAll(C10, this.c10);
        h1 = new Hand(C1);
        h2 = new Hand(C2);
        h3 = new Hand(C3);
        h4 = new Hand(C4);
        h5 = new Hand(C5);
        h6 = new Hand(C6);
        h7 = new Hand(C7);
        h8 = new Hand(C8);
        h9 = new Hand(C9);
        h10 = new Hand(C10);
        Collections.addAll(hands, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10);
    }

    @Test
    public void TestHighestCard() {
        Assertions.assertEquals(h1.highestCard(h1.getCards()), new Card(Rank.Valet, Suit.Carreau));
        Assertions.assertEquals(h2.highestCard(h2.getCards()), new Card(Rank.As, Suit.Trefle));
        Assertions.assertEquals(h3.highestCard(h3.getCards()), new Card(Rank.As, Suit.Trefle));
        Assertions.assertEquals(h4.highestCard(h4.getCards()), new Card(Rank.As, Suit.Trefle));
        Assertions.assertEquals(h5.highestCard(h5.getCards()), new Card(Rank.Sept, Suit.Pique));
        Assertions.assertEquals(h6.highestCard(h6.getCards()), new Card(Rank.Roi, Suit.Pique));
        Assertions.assertEquals(h7.highestCard(h7.getCards()), new Card(Rank.Cinq, Suit.Trefle));
        Assertions.assertEquals(h8.highestCard(h8.getCards()), new Card(Rank.Cinq, Suit.Trefle));
        Assertions.assertEquals(h9.highestCard(h9.getCards()), new Card(Rank.Sept, Suit.Coeur));
        Assertions.assertEquals(h10.highestCard(h10.getCards()), new Card(Rank.As, Suit.Coeur));
    }

    @Test
    public void TestCompareTo() {
        for (int i = 0; i < hands.size(); i++) {
            for (int j = 0; j < hands.size(); j++) {
                if (i == j) {
                    Assertions.assertEquals(0, hands.get(i).compareTo(hands.get(j)));
                } else {
                    if (i < j) {
                        Assertions.assertTrue(hands.get(i).compareTo(hands.get(j)) < 0);
                    } else {
                        Assertions.assertTrue(hands.get(i).compareTo(hands.get(j)) > 0);
                    }
                }
            }
        }
    }

    @Test
    public void TestEquals() {
        for (int i = 0; i < hands.size(); i++) {
            for (int j = 0; j < hands.size(); j++) {
                if (i == j) {
                    Assertions.assertEquals(hands.get(i), hands.get(j));
                } else {
                    Assertions.assertNotEquals(null, hands.get(i));
                    Assertions.assertNotEquals(hands.get(i), hands.get(j));
                }
            }
        }
    }
}