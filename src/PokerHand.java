import java.util.ArrayList;

public class PokerHand {
    public static void main(String [] args) {

        ArrayList<Hand> players = new ArrayList<>();
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

        Game game = new Game(players);
        System.out.println(game);
        game.printWinner();
    }
}
