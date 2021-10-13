import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {
    private final InputStream systemIn;
    private Rank output;
    private ByteArrayInputStream testIn;

    InputReaderTest() {
        this.systemIn = System.in;
        this.output = Rank.Sept;
    }

    @BeforeEach
    void provideInput(String data) {
        this.testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(this.testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(this.systemIn);
    }

    @Test
    void readerTest() {
        String test = "Sept";
        this.provideInput("Sept");
        Rank rank = InputReader.typingRank();
        Assertions.assertEquals(rank, this.output);
    }
}