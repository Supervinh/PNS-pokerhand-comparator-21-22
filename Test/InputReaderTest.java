/* Tests sur la classe InputReader
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 * */

import org.junit.jupiter.api.*;


class InputReaderTest {
    private Rank output = Rank.Seven;
    private Suit output2 = Suit.Carreau;
    @Test
    void rankTest(){
        final String test = "7";
        Rank rank = InputReader.typingRank(test);
        Assertions.assertEquals(rank, output);
    }

    @Test
    void suitTest(){
        final String test = "Carreau";
        Suit suit = InputReader.typingSuit(test);
        Assertions.assertEquals(suit, output2);
    }
}

