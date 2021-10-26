import java.util.*;

/**
 * Classe permettant de créer les mains de poker
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class Hand {
    // Le numéro du joueur.
    private static int playerNum = 0;

    // Le nom du joueur.
    private String name = "Player ";

    // Liste des cards.
    private final ArrayList<Card> cards;

    // Objet combinaison que possède toutes les caractéristiques de la main.
    private final Combinaison C;

    // Le score associé à la main.
    private final int score;

    // Le sous score associé à la main.
    private final int subscore;

    /**
     * Constructeur de la class et initialise le nom du joueur, stock les cartes dans cards puis les trier, ainsi que
     * lancer la class Combinaison() pour ensuite trouver le score et sous score de la main.
     *
     * @param cards Liste de cartes de poker.
     */
    public Hand(ArrayList<Card> cards) {
        Hand.playerNum++;
        this.name += Hand.playerNum;
        this.cards = cards;
        this.sortHand(this.cards);
        this.C = new Combinaison(this);
        this.score = this.C.getScore();
        this.subscore = this.C.getSubscore();
    }

    /**
     * Pour une liste de cartes quelconque retourner la carte la plus forte.
     *
     * @param cards Liste de cartes
     * @return La carte qui se trouve en dernière position de la liste donnée.
     */
    public Card highestCard(ArrayList<Card> cards) {
        return cards.get(cards.size() - 1);
    }

    /**
     * @return Les cartes de la main.
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * @return Le score de la main.
     */
    public int getScore() {
        return score;
    }

    /**
     * @return Le subscore de la main.
     */
    public int getSubscore() {
        return subscore;
    }

    /**
     * @return Le nom du joueur.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Le text composé du nom du joueur suivi par la liste de ses cartes suivi par le type de combinaison
     * de sa main.
     */
    public String toString() {
        return this.name + ": " + this.cards + " \u25B6 " + this.C.getHandRanking();
    }

    /**
     * @return Le message de victoire avec le nom du vainqueur et la combinaison qu'il a obtenue.
     */
    public String handScoreAndSubscoreText() {
        return this.getName() + " with a " + this.C.getHandRanking() + ": " + Rank.rankFromScore(this.subscore);
    }

    /**
     * Calcule la différence entre deux mains pour pouvoir les trier, mais en cas d'égalité on passe sur les
     * sous scores puis sur des methods particulière suivant le type de combinaison afin de départager davantage.
     * S'il y a encore aucune différence, c'est une égalité absolue entre les deux cartes.
     *
     * @param h La deuxième main.
     * @return La différence de score entre deux mains.
     */
    public int compareTo(Hand h) {
        int dif = this.score - h.score;
        if (dif == 0) {
            dif = this.subscore - h.subscore;
            if (dif == 0) {
                ArrayList<Card> c1 = (ArrayList<Card>) this.getCards().clone();
                ArrayList<Card> c2 = (ArrayList<Card>) h.getCards().clone();
                switch (this.score) {
                    case 3 -> dif = this.methodTwoPair(h, c1, c2);
                    case 2 -> dif = this.methodPair(h, c1, c2);
                    default -> dif = this.methodHighestCard(h, c1, c2);
                }
            }
        }
        return dif;
    }

    /**
     * Method de triage pour les mains qui sont des 'Double Pairs'.
     * On enlève les cartes appartenant à la 'pair' la plus forte pour ensuite comparer les deux nouvellement mains.
     * Si les deux nouvelles mains ont encore le meme score alors on fait la méthode des 'Pairs'.
     *
     * On passe une copy les listes de cartes comme ça on peut modifier cette liste sans affecter réellement les cartes
     * dans la main des joueurs.
     *
     * @param h L'autre main avec qui on compare.
     * @param c1 Copy de la liste de cartes de la premiere main.
     * @param c2 Copy de la liste de cartes de la deuxième main.
     * @return La différence de score entre les deux mains.
     */
    public int methodTwoPair(Hand h, ArrayList<Card> c1, ArrayList<Card> c2) {
        c1.removeIf(card -> card.getForce() == this.subscore);
        c2.removeIf(card -> card.getForce() == h.subscore);
        Hand h1 = new Hand(c1);
        Hand h2 = new Hand(c2);
        int dif = h1.subscore - h2.subscore;
        if (dif == 0) {
            c1.removeIf(card -> card.getForce() == h1.subscore);
            c2.removeIf(card -> card.getForce() == h2.subscore);
            dif = this.methodHighestCard(h, c1, c2);
        }
        return dif;
    }

    /**
     * Method de triage pour les mains qui sont des 'Pairs'.
     * On enlève les cartes appartenant à la 'pair' pour ensuite repasser sur la méthode des cartes un à un.
     *
     * On passe une copy les listes de cartes comme ça on peut modifier cette liste sans affecter réellement les cartes
     * dans la main des joueurs.
     *
     * @param h L'autre main avec qui on compare.
     * @param c1 Copy de la liste de cartes de la premiere main.
     * @param c2 Copy de la liste de cartes de la deuxième main.
     * @return La method pour les cartes à comparer un à un.
     */
    public int methodPair(Hand h, ArrayList<Card> c1, ArrayList<Card> c2) {
        c1.removeIf(card -> card.getForce() == this.subscore);
        c2.removeIf(card -> card.getForce() == h.subscore);
        return this.methodHighestCard(h, c1, c2);
    }

    /**
     * Method de triage pour les mains qui nécessite de comparer les cartes un à un (Quinte/Couleur/Suite, etc.).
     * Tant que c1 et c2 sont pas vide que la differance est 0, alors on récupère la force de la carte la plus forte
     * de chaque liste et on fait leur différence.
     * Si la différence est égale à zero alors on enlève ces cartes de la liste et on continue de comparer.
     *
     * On passe une copy les listes de cartes comme ça on peut modifier cette liste sans affecter réellement les cartes
     * dans la main des joueurs.
     *
     * @param h L'autre main avec qui on compare.
     * @param c1 Copy de la liste de cartes de la premiere main.
     * @param c2 Copy de la liste de cartes de la deuxième main.
     * @return La différence de score entre les deux mains.
     */
    public int methodHighestCard(Hand h, ArrayList<Card> c1, ArrayList<Card> c2) {
        int dif = 0;
        while (!c1.isEmpty() && !c2.isEmpty() && dif == 0) {
            dif = this.highestCard(c1).getForce() - h.highestCard(c2).getForce();
            c1.remove(c1.size() - 1);
            c2.remove(c2.size() - 1);
        }
        return dif;
    }

    /**
     * Permet de trier une liste de carte.
     *
     * @param cards Une liste de Carte.
     */
    public void sortHand(ArrayList<Card> cards) {
        cards.sort(new CardComparator());
    }

    /**
     * @param obj L'autre main qu'on veut comparer.
     * @return Si deux Main sont identique.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
