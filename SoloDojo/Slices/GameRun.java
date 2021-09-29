package SoloDojo.Slices;

import java.util.ArrayList;
import java.util.Scanner;

public class GameRun {
    
    public static final Scanner CONSOLE = new Scanner(System.in);

    static public void clearCmd() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    public static void main(String[] args) {
        clearCmd();
        int nbCards=0, force = 0;
        ArrayList<Card> cards = new ArrayList<>();
        System.out.print("Player 1 - Enter number of Cards: ");
        nbCards = CONSOLE.nextInt();
        for (int i = 0; i < nbCards; i++) {
            System.out.print("Card " + (i+1) + " : ");
            force = CONSOLE.nextInt();
            cards.add(new Card(force));
            
        }
        Hand player1 = new Hand(cards);
        cards.clear();

        for (int i = 0; i < nbCards; i++) {
            System.out.print("Card " + (i+1) + " : ");
            force = CONSOLE.nextInt();
            cards.add(new Card(force));
            
        }
        Hand player2 = new Hand(cards);

        clearCmd();
        System.out.println(player1);
        System.out.println(player2);
        ShowWinner(player1);
    }
}
