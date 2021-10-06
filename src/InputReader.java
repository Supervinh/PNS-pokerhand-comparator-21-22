import java.util.*;

public class InputReader {
    public static final Scanner CONSOLE = new Scanner(System.in);
    public InputReader(){

    }
    public String readGame(){
        String message =  CONSOLE.nextLine();
        return message;
    }
}
