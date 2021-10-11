import java.util.ArrayList;

public class PokerHand {
    public static void main(String [] args) {

        ArrayList<Hand> players = new ArrayList<>();
        Card card;

        for (int j = 1; j < Game.numberOfPlayers + 1; j++) {
            ArrayList<Card> cards = new ArrayList<>();
            System.out.println("\nPlayer " + j);
            for (int i = 1; i < Game.numberOfCards + 1; i++) {
                System.out.println("Carte " + i + ":");
                if (Game.automaticCards) {
                    card = Game.deck.drawCard();
                } else {
                    card = Game.deck.takeCard(new Card(InputReader.typingRank(), InputReader.typingSuit()));
                }
                cards.add(card);
            }
            players.add(new Hand(cards));
        }

        Game game = new Game(players);
        System.out.println(game);
        //System.out.println("\nLa main gagnante est: ");
        // A Faire la Methode

    }
}
