import java.util.*;

public class Hand {
    private static int playerNum = 0;
    private final ArrayList<Card> cards;
    private String name = "Player ";
    private int score;
    private int subscore;

    public Hand(ArrayList<Card> cards){
        Hand.playerNum++;
        this.cards = cards;
        this.name += Hand.playerNum;
        this.sortHand(this.cards);
        this.evaluateHand();
    }

    public void sortHand(ArrayList<Card> cards) {
        cards.sort(new CardComparator());
    }

    public Card highestCard(ArrayList<Card> cards){
        return cards.get(cards.size()-1);
    }

    public void evaluateHand() {
        // Plus qu'à Identifier type de la main et attribuer des points en fonctions. et aussi donner des sous points pour comparer deux main du meme type.
        this.score = 0;
        this.subscore = this.highestCard(this.getCards()).getForce();
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return score;
    }

    public int getSubscore() {
        return subscore;
    }

    public String toString(){
        return this.name + " : " + this.cards;
    }

    public int compareTo(Hand h) {
        int dif = this.score - h.score;
        if (dif == 0) {
            dif = this.subscore - h.subscore;
            if (dif == 0 && this.score==0) {
                ArrayList<Card> c1 = (ArrayList<Card>) this.getCards().clone();
                ArrayList<Card> c2 = (ArrayList<Card>) h.getCards().clone();
                int subscore1=0, subscore2=0;
                while (!c1.isEmpty() && !c2.isEmpty() && subscore1 == subscore2) {
                    subscore1 = this.highestCard(c1).getForce();
                    subscore2 = h.highestCard(c2).getForce();
                    c1.remove(c1.size()-1);
                    c2.remove(c2.size()-1);
                }
                return subscore1-subscore2;
            }
        }
        return dif;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
