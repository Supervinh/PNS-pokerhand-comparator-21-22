// Classe créant un deck de 52 cartes
import java.util.ArrayList;
import java.util.Random;

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

    public void shuffleDeck() {
        Random rand = new Random();
        ArrayList<Card> tempDeck = new ArrayList<>();
        // On utilise un deck temporaire dans lequel on stocke les cartes prises aléatoirement dans le deck de base pour pouvoir le mélanger
        while (!this.deck.isEmpty()) {
            tempDeck.add(this.deck.remove(rand.nextInt(this.deck.size())));
        }
        this.deck = tempDeck;
    }

    // mode de pioche automatique (pour pouvoir tester les tests plus rapidement)
    public Card drawCard() {
        if (!this.deck.isEmpty()) {
            return this.deck.remove(0);
        }
        System.out.println("No more Cards - End of Game.");
        System.exit(0);
        return null;
    }

    // mode de pioche classique
    public Card takeCard(Card c) {
        if (this.deck.isEmpty()){
            System.out.println("No more Cards - End of Game.");
            System.exit(0);
            return null;
        }
        // Si la carte est contenu dans le deck on la pioche sinon on demande de saisir une nouvelle carte
        if (this.deck.contains(c)) {
            for (int i = 0; i < this.deck.size(); i++) {
                if (this.deck.get(i).equals(c)) {
                    this.deck.remove(i);
                }
            }
            return c;
        }
        System.out.println("Card has already been Drawn - Try again.");
        return takeCard(new Card(InputReader.typingRank(), InputReader.typingSuit()));
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        return "Deck " + deck + ", nbCards=" + deck.size();
    }
}
