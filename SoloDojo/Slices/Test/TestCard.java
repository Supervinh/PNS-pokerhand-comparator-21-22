package SoloDojo.Slices.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import SoloDojo.Slices.Card;

public class TestCard {
    public Card c1;
    public Card c0;
    public Card c_1;
    public Card c14;
    public Card c15;

    @BeforeEach
    public void setUp() {
        c1 = new Card(1);
        c0 = new Card(0);
        c_1 = new Card(-1);
        c14 = new Card(14);
        c15 = new Card(15);
    }
    
    @Test 
    public void testEquals() {
        assertEquals(14, c1.getForce());
        assertEquals(c14.getForce(), c1.getForce());
    }


}
