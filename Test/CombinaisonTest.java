/* Tests sur la classe Combinaison
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 * */

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.Collections;



public class CombinaisonTest {
    private Combinaison combinaison1;
    private Combinaison combinaison2;
    private Combinaison combinaison3;
    private Combinaison combinaison4;
    private Combinaison combinaison5;
    private Combinaison combinaison6;
    private Combinaison combinaison7;
    private Combinaison combinaison8;
    private Combinaison combinaison9;
    private Combinaison combinaison10;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private ArrayList<Card> liste1;
    private ArrayList<Card> liste2;
    private ArrayList<Card> liste3;
    private ArrayList<Card> liste4;
    private ArrayList<Card> liste5;
    private ArrayList<Card> liste6;
    private ArrayList<Card> liste7;
    private ArrayList<Card> liste8;
    private ArrayList<Card> liste9;
    private ArrayList<Card> liste10;
    private Hand hand1;
    private Hand hand2;
    private Hand hand3;
    private Hand hand4;
    private Hand hand5;
    private Hand hand6;
    private Hand hand7;
    private Hand hand8;
    private Hand hand9;
    private Hand hand10;

    @BeforeEach
    public void setUp() {
        // Carte dominante
        card1 = new Card(Rank.Ace, Suit.Coeur);
        card2 = new Card(Rank.Jack, Suit.Pique);
        card3 = new Card(Rank.Four, Suit.Trefle);
        card4 = new Card(Rank.Nine, Suit.Carreau);
        card5 = new Card(Rank.Two, Suit.Carreau);
        liste1 = new ArrayList<>();
        Collections.addAll(liste1, card1, card2, card3, card4, card5);
        hand1 = new Hand(liste1);

        // Paire de Valets
        card1 = new Card(Rank.Jack, Suit.Pique);
        card4 = new Card(Rank.Ten, Suit.Carreau);
        liste2 = new ArrayList<>();
        Collections.addAll(liste2, card1, card2, card3, card4, card5);
        hand2 = new Hand(liste2);

        // Deux paires
        card1 = new Card(Rank.Ace, Suit.Coeur);
        card2 = new Card(Rank.Ace, Suit.Pique);
        card3 = new Card(Rank.Nine, Suit.Trefle);
        card4 = new Card(Rank.Nine, Suit.Carreau);
        card5 = new Card(Rank.Two, Suit.Carreau);
        liste3 = new ArrayList<>();
        Collections.addAll(liste3, card1, card2, card3, card4, card5);
        hand3 = new Hand(liste3);

        //Brelan
        card1 = new Card(Rank.Ten, Suit.Coeur);
        card2 = new Card(Rank.Seven, Suit.Coeur);
        card3 = new Card(Rank.Two, Suit.Trefle);
        card4 = new Card(Rank.Two, Suit.Trefle);
        card5 = new Card(Rank.Two, Suit.Carreau);
        liste4 = new ArrayList<>();
        Collections.addAll(liste4, card1, card2, card3, card4, card5);
        hand4 = new Hand(liste4);

        //Suite
        card1 = new Card(Rank.Ten, Suit.Coeur);
        card2 = new Card(Rank.Nine, Suit.Coeur);
        card3 = new Card(Rank.Six, Suit.Trefle);
        card4 = new Card(Rank.Seven, Suit.Trefle);
        card5 = new Card(Rank.Eight, Suit.Carreau);
        liste5 = new ArrayList<>();
        Collections.addAll(liste5, card1, card2, card3, card4, card5);
        hand5 = new Hand(liste5);

        //Couleur
        card1 = new Card(Rank.Ace, Suit.Carreau);
        card2 = new Card(Rank.Ace, Suit.Carreau);
        card3 = new Card(Rank.Nine, Suit.Carreau);
        card4 = new Card(Rank.Nine, Suit.Carreau);
        card5 = new Card(Rank.Two, Suit.Carreau);
        liste6 = new ArrayList<>();
        Collections.addAll(liste6, card1, card2, card3, card4, card5);
        hand6 = new Hand(liste6);

        //Full
        card1 = new Card(Rank.King, Suit.Pique);
        card2 = new Card(Rank.Queen, Suit.Coeur);
        card3 = new Card(Rank.Queen, Suit.Pique);
        card4 = new Card(Rank.King, Suit.Trefle);
        card5 = new Card(Rank.King, Suit.Coeur);
        liste7 = new ArrayList<>();
        Collections.addAll(liste7, card1, card2, card3, card4, card5);
        hand7 = new Hand(liste7);

        //Carré
        card1 = new Card(Rank.King, Suit.Pique);
        card2 = new Card(Rank.King, Suit.Trefle);
        card3 = new Card(Rank.Ten, Suit.Pique);
        card4 = new Card(Rank.King, Suit.Carreau);
        card5 = new Card(Rank.King, Suit.Coeur);
        liste8 = new ArrayList<>();
        Collections.addAll(liste8, card1, card2, card3, card4, card5);
        hand8 = new Hand(liste8);

        //Staight flush
        card1 = new Card(Rank.Ten, Suit.Coeur);
        card2 = new Card(Rank.Nine, Suit.Coeur);
        card3 = new Card(Rank.Eight, Suit.Coeur);
        card4 = new Card(Rank.Seven, Suit.Coeur);
        card5 = new Card(Rank.Six, Suit.Coeur);
        liste9 = new ArrayList<>();
        Collections.addAll(liste9, card1, card2, card3, card4, card5);
        hand9 = new Hand(liste9);

        // Royal Flush
        card1 = new Card(Rank.Ace, Suit.Coeur);
        card2 = new Card(Rank.King, Suit.Coeur);
        card3 = new Card(Rank.Queen, Suit.Coeur);
        card4 = new Card(Rank.Jack, Suit.Coeur);
        card5 = new Card(Rank.Ten, Suit.Coeur);
        liste10 = new ArrayList<>();
        Collections.addAll(liste10, card1, card2, card3, card4, card5);
        hand10 = new Hand(liste10);

        // Combinaisons
        combinaison1 = new Combinaison(hand1);
        combinaison2 = new Combinaison(hand2);
        combinaison3 = new Combinaison(hand3);
        combinaison4 = new Combinaison(hand4);
        combinaison5 = new Combinaison(hand5);
        combinaison6 = new Combinaison(hand6);
        combinaison7 = new Combinaison(hand7);
        combinaison8 = new Combinaison(hand8);
        combinaison9 = new Combinaison(hand9);
        combinaison10 = new Combinaison(hand10);

    }

    @Test
    void TestSetSuite_table(){
        Assertions.assertEquals(Arrays.asList(1,1,1,2), combinaison1.getSuit_table());
        Assertions.assertEquals(Arrays.asList(1,2,0,2), combinaison2.getSuit_table());
        Assertions.assertEquals(Arrays.asList(0,0,5,0), combinaison10.getSuit_table());
    }

    @Test
    void TestSetRank_table(){
        Assertions.assertEquals(Arrays.asList(1,0,1,0,0,0,0,1,0,1,0,0,1), combinaison1.getRank_table());
        Assertions.assertEquals(Arrays.asList(1,0,1,0,0,0,0,0,1,2,0,0,0), combinaison2.getRank_table());
        Assertions.assertEquals(Arrays.asList(0,0,0,0,0,0,0,0,1,1,1,1,1), combinaison10.getRank_table());
    }

    @Test
    void TestSetConsecutiveCards(){
        Assertions.assertEquals(1, combinaison1.getNumberOfConsecutiveCards());
        Assertions.assertEquals(2, combinaison2.getNumberOfConsecutiveCards());
        Assertions.assertEquals(5, combinaison10.getNumberOfConsecutiveCards());
    }

    @Test
    void TestIsPair(){
        Assertions.assertEquals(2, combinaison2.isPair());
    }

    @Test
    void TestIsTwoPair(){
        Assertions.assertEquals(3, combinaison3.isTwoPair());
    }

    @Test
    void TestIsThreeOfAKind(){
        Assertions.assertEquals(4, combinaison4.isThreeOfAKind());
    }

    @Test
    void TestIsStraight(){
        Assertions.assertEquals(5, combinaison5.isStraight());
    }

    @Test
    void TestIsFlush(){
        Assertions.assertEquals(6, combinaison6.isFlush());
    }

    @Test
    void TestIsFullHouse(){
        Assertions.assertEquals(7, combinaison7.isFullHouse());
    }

    @Test
    void TestIsFourOfAKind(){
        Assertions.assertEquals(8, combinaison8.isFourOfAKind());
    }

    @Test
    void TestIsStraightFlush(){
        Assertions.assertEquals(9, combinaison9.isStraightFlush());
    }

    @Test
    void TestIsRoyalFlush(){
        Assertions.assertEquals(2, combinaison2.isRoyalFlush());
        Assertions.assertEquals(10, combinaison10.isRoyalFlush());
    }
}
