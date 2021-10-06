import java.util.*;

public class PokerHand {
    public static void main(String [] args){
        InputReader ir = new InputReader();
        ArrayList<Card> cartes1 = new ArrayList<>();
        ArrayList<Card> cartes2 = new ArrayList<>();
        System.out.println("Première main");
        for (int i = 1; i < 3; i++){
            System.out.print("Entrez la force de la carte " + i + ": ");
            String force = ir.readGame();
            System.out.print("Entrez le symbole de la carte " + i + ": ");
            String symbole = ir.readGame();
            Card carte = new Card(symbole, force);
            cartes1.add(carte);
        }
        System.out.println("Seconde main");
        for (int j = 1; j < 3; j++){
            System.out.print("Entrez la force de la carte " + j + ": ");
            String force = ir.readGame();
            System.out.print("Entrez le symbole de la carte " + j + ": ");
            String symbole = ir.readGame();
            Card carte = new Card(symbole, force);
            cartes2.add(carte);
        }
        Hand main1 = new Hand(cartes1, "Main 1");
        Hand main2 = new Hand(cartes2, "Main 2");
        Game game = new Game(main1, main2);
        System.out.println(game);
        System.out.println("La main gagnante est: ");
        System.out.println(game.compete());
    }
}
