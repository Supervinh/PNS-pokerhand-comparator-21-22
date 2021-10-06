import java.util.ArrayList;

public class PokerHand {
    public static void main(String [] args){
        InputReader ir = new InputReader();
        ArrayList<Card> cartes1 = new ArrayList<>();
        ArrayList<Card> cartes2 = new ArrayList<>();
        System.out.println("\nPremière main");
        for (int i = 1; i < 3; i++){
            System.out.println("Carte " + i + ":");
            Card carte = new Card(InputReader.typingRank(), InputReader.typingSuit());
            cartes1.add(carte);
        }
        System.out.println("\nSeconde main");
        for (int j = 1; j < 3; j++){
            System.out.println("Carte " + j + ":");
            Card carte = new Card(InputReader.typingRank(), InputReader.typingSuit());
            cartes2.add(carte);
        }
        Hand main1 = new Hand(cartes1);
        Hand main2 = new Hand(cartes2);
        Game game = new Game(main1, main2);

        System.out.println("\nLa main gagnante est: ");
        System.out.println(game);
    }
}
