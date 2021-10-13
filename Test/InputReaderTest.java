import org.junit.jupiter.api.*;

import java.io.*;

/*import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;*/

class InputReaderTest {

    private final InputStream systemIn = System.in;
    private Rank output = Rank.Sept;
    private ByteArrayInputStream testIn;

    @BeforeEach
    void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    void readerTest(){
        final String test = "Sept";
        provideInput(test);

        Rank rank = InputReader.typingRank();

        Assertions.assertEquals(rank, output);




        /*InputStream test = System.in;
        System.setIn(new ByteArrayInputStream("3\n4\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        rank = InputReader.typingRank();

        System.setIn(test);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "output:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        Assertions.assertEquals(output, "7" );*/

    }
}

//hahaha

