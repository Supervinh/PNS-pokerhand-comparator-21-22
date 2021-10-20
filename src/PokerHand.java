import java.util.ArrayList;
import java.util.Map;

public class PokerHand {
    public static void main(String [] args) {
        // Game Global Settings like player number, card number and auto draw card is in the Game Class as static fields.

        ArrayList<Hand> players = new ArrayList<>();
        Card card;
        for (int i = 0; i < Game.numberOfPlayers; i++) {
            ArrayList<Card> cards = new ArrayList<>();
            if (!Game.automaticCards) {
                System.out.println("\n=== Player " + (i+1) + " ===");
                ArrayList[] ranksandsuits = InputReader.typingHand();
                for (int k = 0; k < Math.min(ranksandsuits[0].size(), ranksandsuits[1].size()); k++) {
                    cards.add(Game.deck.takeCard(new Card(InputReader.typingRank((String) (ranksandsuits[0]).get(k)), InputReader.typingSuit((String) (ranksandsuits[1]).get(k)))));
                }
            } else {
                for (int j = 0; j < Game.numberOfCards; j++) {
                    cards.add(Game.deck.drawCard());
                }
            }
            players.add(new Hand(cards));
        }
        
//        ArrayList<Hand> players = new ArrayList<>();
//        Card card;
//
//        for (int j = 1; j < Game.numberOfPlayers + 1; j++) {
//            ArrayList<Card> cards = new ArrayList<>();
//            if (!Game.automaticCards) {
//                System.out.println("\n=== Player " + j + " ===");
//            }
//            for (int i = 1; i < Game.numberOfCards + 1; i++) {
//                if (Game.automaticCards) {
//                    card = Game.deck.drawCard();
//                } else {
//                    System.out.println("Carte " + i + ":");
//                    card = Game.deck.takeCard(new Card(InputReader.typingRank(), InputReader.typingSuit()));
//                }
//                cards.add(card);
//            }
//            players.add(new Hand(cards));
//        }

        Game game = new Game(players);
        // System.out.println(game);
        game.printWinner();
    }
}
