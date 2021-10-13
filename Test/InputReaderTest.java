import org.junit.jupiter.api.*;

import java.io.*;

class InputReaderTest {
    private Rank output = Rank.Sept;
    private Suit output2 = Suit.Carreau;
    @Test
    void rankTest(){
        final String test = "Sept";

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

