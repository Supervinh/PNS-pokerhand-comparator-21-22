import org.junit.jupiter.api.*;


class InputReaderTest {
    private Rank output = Rank.Sept;
    private Suit output2 = Suit.Carreau;
    @Test
    void rankTest(){
        final String test = "7";
        Rank rank = InputReader.typingRank(test);
        Assertions.assertEquals(rank, output);
    }

   /* @Test
    void rankTest2(){
        final String test = "Cinquante";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputReader.typingRank(test);
        });
    }*/

    @Test
    void suitTest(){
        final String test = "Carreau";
        Suit suit = InputReader.typingSuit(test);
        Assertions.assertEquals(suit, output2);
    }
}

