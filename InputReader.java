import java.util.Scanner;

public class InputReader {

    public static final Scanner CONSOLE = new Scanner(System.in);

    public static String inpuString(){
        return CONSOLE.nextLine();
    }

    public static int inputInt() {
        return CONSOLE.nextInt();
    }
}
