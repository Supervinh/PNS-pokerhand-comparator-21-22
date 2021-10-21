/* Tests sur la classe Combinaison
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 * */

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.Collections;


class CombinaisonTest {
    private Combinaison combinaison1;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private ArrayList<Card> liste1;
    private Hand hand1;
    private Hand hand2;


    @BeforeEach
    public void setUp() {
        // Carte dominante
        card1 = new Card(Rank.As, Suit.Coeur);
        card2 = new Card(Rank.Valet, Suit.Pique);
        card3 = new Card(Rank.Quatre, Suit.Trefle);
        card4 = new Card(Rank.Dix, Suit.Carreau);
        card5 = new Card(Rank.Deux, Suit.Carreau);
        liste1 = new ArrayList<>();
        Collections.addAll(liste1, card1, card2, card3, card4, card5);
        hand1 = new Hand(liste1);


        // Paire de Valets
        card1 = new Card(Rank.Valet, Suit.Trefle);
        card2 = new Card(Rank.Valet, Suit.Coeur);
        card3 = new Card(Rank.Quatre, Suit.Coeur);
        card4 = new Card(Rank.Dix, Suit.Pique);
        card5 = new Card(Rank.Deux, Suit.Trefle);
        liste1 = new ArrayList<>();
        Collections.addAll(liste1, card1, card2, card3, card4, card5);
        hand2 = new Hand(liste1);

        // Combinaison
        combinaison1 = new Combinaison(hand2);

    }

    @Test
    void TestSetSuite_table(){
        Assertions.assertEquals(Arrays.asList(2,1,2,0), combinaison1.getSuit_table());
    }

    @Test
    void TestSetRank_table(){
        Assertions.assertEquals(Arrays.asList(1,0,1,0,0,0,0,0,1,2,0,0,0), combinaison1.getRank_table());
    }

    @Test
    void TestSetConsecutiveCards(){
        Assertions.assertEquals(2, combinaison1.getNumberOfConsecutiveCards());
    }
}
