package SoloDojo.Slices;

import java.util.Scanner;

public class InputReader {

    public static String readGame(){
        Scanner sc = new Scanner(System.in);
        String message =  sc.nextLine();
        sc.close();
        return message;
    }
}
