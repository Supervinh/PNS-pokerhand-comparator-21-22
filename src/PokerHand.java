import java.util.*;

public class PokerHand {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez la force de la carte: ");
        String force = sc.nextLine();
        Card carte1 = new Card("Tr", force);
        System.out.println("Entrez la force de la carte: ");
        force = sc.nextLine();
        Card carte2 = new Card("Co", force);
        Hand main1 = new Hand(carte1, "Main 1");
        Hand main2 = new Hand(carte2, "Main 2");
        Game game = new Game(main1, main2);
        System.out.println(game);
        System.out.println("La main gagnante est: ");
        System.out.println(game.compete());
        sc.close();
    }
}
