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

    private int consecutiveCards(){
        int compteur_max = 0, compteur = 0;
        for (Integer integer : this.Rank_table) {
            if (integer != 0) {
                compteur++;
            } else {
                compteur_max = Math.max(compteur, compteur_max);
                compteur = 0;
            }
        }
        return compteur_max;
    }

}
