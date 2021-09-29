package SoloDojo.Slices;

import java.util.Scanner;

public class GameRun {
    
    public static final Scanner CONSOLE = new Scanner(System.in);

    static public void clearCmd() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    static public void ShowWinner(Hand h1, Hand h2) {
        System.out.print("The Winner is ");
        if (h1.getCard().getForce() > h2.getCard().getForce()) {
            System.out.println(h1);
        } else {
            System.out.println(h2);
        }
    }

    public static void main(String[] args) {
        clearCmd();
        int force = 0;
        System.out.print("Player 1 enter Card: ");
        force = CONSOLE.nextInt();
        Hand player1 = new Hand(new Card(force));

        System.out.print("Player 2 enter Card: ");
        force = CONSOLE.nextInt();
        Hand player2 = new Hand(new Card(force));

        clearCmd();
        System.out.println(player1);
        System.out.println(player2);
        ShowWinner(player1, player2);
    }
}
