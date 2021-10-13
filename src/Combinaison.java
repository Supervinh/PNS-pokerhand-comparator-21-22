import java.util.*;

public class Combinaison {
    private ArrayList<Integer> Suit_table = new ArrayList<Integer>();
    private ArrayList<Integer> Rank_table = new ArrayList<Integer>();
    private Hand h;

    public Combinaison (Hand h){
        this.h = h;
        this.setSuit_table();
        this.setRank_table();
    }

    private void setSuit_table() {
        int Trefle = 0, Pique = 0, Coeur = 0, Carreau = 0;
        for (Card c: this.h.getCards()) {
            if (c.getSuit().equals(Suit.Trefle)) {
                Trefle++;
            } else if (c.getSuit().equals(Suit.Pique)) {
                Pique++;
            } else if (c.getSuit().equals(Suit.Coeur)) {
                Coeur++;
            } else if (c.getSuit().equals(Suit.Carreau)) {
                Carreau++;
            }
        }
        this.Suit_table.add(Trefle);
        this.Suit_table.add(Pique);
        this.Suit_table.add(Coeur);
        this.Suit_table.add(Carreau);
    }

    private void setRank_table() {
        for (Rank rank: Rank.values()) {
            int sum = 0;
            for (Card c: this.h.getCards()) {
                if (c.getRank().equals(rank)){
                   sum++;
                }
            }
            this.Rank_table.add(sum);
        }
    }
<<<<<<< HEAD

    private int consecutiveCards(){
        int compteur_max = 0;
        int compteur = 0;
        for (int i = 0; i < this.Rank_table.size(); i++){
            if (this.Rank_table.get(i) != 0){
                compteur_max++;
            }
            else{
                compteur = 0;
            }
        }
        return compteur_max;
    }
=======
>>>>>>> 3d6ce8037eb05fe8fcc103276c650c0a4a0f6a50
}
