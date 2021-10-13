import org.junit.jupiter.api.*;

import java.io.*;

class InputReaderTest {

    private Rank output = Rank.Sept;

    @Test
    void readerTest(){
        final String test = "Sept";

        Rank rank = InputReader.typingRank(test);

        Assertions.assertEquals(rank, output);

    }
}

