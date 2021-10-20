/* Tests sur la classe Card
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 * */

import org.junit.jupiter.api.*;

class CardTest {
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    @BeforeEach
    public void setUp() {
        card1 = new Card(Rank.As, Suit.Coeur);
        card2 = new Card(Rank.Valet, Suit.Pique);
        card3 = new Card(Rank.Quatre, Suit.Trefle);
        card4 = new Card(Rank.Dix, Suit.Carreau);
    }

    @Test
    public void TestGetSuit() {
        Assertions.assertEquals(Suit.Coeur, card1.getSuit());
        Assertions.assertEquals(Suit.Pique, card2.getSuit());
        Assertions.assertEquals(Suit.Trefle, card3.getSuit());
        Assertions.assertEquals(Suit.Carreau, card4.getSuit());
    }

    @Test
    public void TestGetRank() {
        Assertions.assertEquals(Rank.As, card1.getRank());
        Assertions.assertEquals(Rank.Valet, card2.getRank());
        Assertions.assertEquals(Rank.Quatre, card3.getRank());
        Assertions.assertEquals(Rank.Dix, card4.getRank());
    }

    @Test
    public void TestGetForce() {
        Assertions.assertEquals(14, card1.getForce());
        Assertions.assertEquals(11, card2.getForce());
        Assertions.assertEquals(4, card3.getForce());
        Assertions.assertEquals(10, card4.getForce());
    }

    @Test
    public void TestCompareTo() {
        Assertions.assertEquals(0, card1.compareTo(card1));
        Assertions.assertTrue(card1.compareTo(card2) > 0);
        Assertions.assertTrue(card3.compareTo(card1) < 0);
        Assertions.assertTrue(card3.compareTo(card4) < 0);
    }

    @Test
    public void TestEquals() {
        Assertions.assertEquals(card1, card1);
        Assertions.assertNotEquals(null, card1);
        Assertions.assertNotEquals(card3, card4);
    }
}