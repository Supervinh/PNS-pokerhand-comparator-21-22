import java.util.*;

public class PokerHand {
    public static void main(String [] args){
        InputReader ir = new InputReader();
        ArrayList<Card> cartes1 = new ArrayList<>();
        ArrayList<Card> cartes2 = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            System.out.println("Entrez la force de la carte " + i + ": ");
            String force = ir.readGame();
            System.out.println("Entrez le symbole de la carte " + i + ": ");
            String symbole = ir.readGame();
            Card carte = new Card(symbole, force);
            cartes1.add(carte);
        }

        for (int j = 0; j < 5; j++){
            System.out.println("Entrez la force de la carte " + j + ": ");
            String force = ir.readGame();
            System.out.println("Entrez le symbole de la carte " + j + ": ");
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
