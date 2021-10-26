import java.util.ArrayList;

/**
 * Classe permettant de Lancer le programme.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class PokerHand {
    public static void main(String[] args) {

        // Ajout de n Joueurs avec leurs mains de x cartes dans le Jeu.
        ArrayList<Hand> players = new ArrayList<>();
        for (int i = 0; i < Game.numberOfPlayers; i++) {
            ArrayList<Card> cards = new ArrayList<>();
            // Choix de Method pour piocher les cartes.
            if (!Game.automaticCards) {
                System.out.println("\n=== Player " + (i + 1) + " ===");
                ArrayList[] ranksAndSuits = InputReader.typingHand();
                for (int k = 0; k < Math.min(ranksAndSuits[0].size(), ranksAndSuits[1].size()); k++) {
                    cards.add(Game.deck.takeCard(new Card(InputReader.typingRank((String) (ranksAndSuits[0]).get(k)), InputReader.typingSuit((String) (ranksAndSuits[1]).get(k)))));
                }
            } else {
                for (int j = 0; j < Game.numberOfCards; j++) {
                    cards.add(Game.deck.drawCard());
                }
            }
            players.add(new Hand(cards));
        }

        // Debut du jeu en ajoutant les différents joueurs, puis afficher leurs mains ansi que le Gagnant.
        Game game = new Game(players);
        System.out.println(game);
        game.printWinner();
    }
}
