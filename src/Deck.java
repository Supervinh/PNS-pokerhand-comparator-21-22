import java.util.ArrayList;
import java.util.Random;

/**
 * Classe permettant de créer un jeu de carte pour ensuite les piocher.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        // Pour chaque rang on ajoute dans le deck tous les symboles de ce rang ie (pour 2 -> 2Co, 2Pi, 2Ca, 2Tr)
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        // Mélange le deck entre 10 et 20 fois pour être sûr que ce soit bien mélangé
        Random rand = new Random();
        for (int i = 0; i < Math.max(10, rand.nextInt(20)); i++) {
            this.shuffleDeck();
        }
    }

    /**
     * Mélange le deck de manière aléatoire en utilisant un deck temporaire
     */
    public void shuffleDeck() {
        Random rand = new Random();
        ArrayList<Card> tempDeck = new ArrayList<>();
        // On utilise un deck temporaire dans lequel on stocke les cartes prises aléatoirement dans le deck de base pour pouvoir le mélanger
        while (!this.deck.isEmpty()) {
            tempDeck.add(this.deck.remove(rand.nextInt(this.deck.size())));
        }
        this.deck = tempDeck;
    }

    /**
     * Pioche automatique pour créer une main (pour pouvoir faire nos tests plus rapidement)
     * @return la première carte du deck si le deck n'est pas vide sinon null.
     */
    public Card drawCard() {
        if (!this.deck.isEmpty()) {
            return this.deck.remove(0);
        }
        System.out.println("No more Cards - End of Game.");
        System.exit(0);
        return null;
    }

    /**
     * Pioche classique pour créer une main en vérifiant que la carte n'a pas déjà été tirée
     * @return la carte c choisie si le deck contient la carte, null si le deck et vide et s'appelle elle même si la carte a déjà été piochée
     */
    public Card takeCard(Card c) {
        if (this.deck.isEmpty()) {
            System.out.println("No more Cards - End of Game.");
            System.exit(0);
            return null;
        }
        // Si la carte est contenue dans le deck on la pioche sinon on demande de saisir une nouvelle carte
        if (this.deck.contains(c)) {
            for (int i = 0; i < this.deck.size(); i++) {
                if (this.deck.get(i).equals(c)) {
                    this.deck.remove(i);
                }
            }
            return c;
        }
        System.out.println(c + " has already been Drawn - Try again.");
        return takeCard(new Card(InputReader.typingRank(), InputReader.typingSuit()));
    }

    /**
     * @return le deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * @return un string donnant le deck et le nombre de cartes
     */
    @Override
    public String toString() {
        return "Deck :" + deck + ", nbCards=" + deck.size();
    }
}
