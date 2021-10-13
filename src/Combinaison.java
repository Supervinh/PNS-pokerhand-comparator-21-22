import java.util.*;

public class Combinaison {
    private final Hand h;
    private final ArrayList<Integer> Suit_table = new ArrayList<>();
    private final ArrayList<Integer> Rank_table = new ArrayList<>();
    private final int numberOfConsecutiveCards;
    private final int score;
    private final int subscore;


    public Combinaison (Hand h){
        this.h = h;
        this.setSuit_table();
        this.setRank_table();
        this.score = this.getScoreOfHand();
        this.subscore = this.getSubScoreOfHand();
        this.numberOfConsecutiveCards = this.consecutiveCards();
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

    public Rankings showHandRanking() {
        for (Rankings rankings : Rankings.values()) {
            if (rankings.getValue() == this.score) {
                return rankings;
            }
        }
        return Rankings.HighCard;
    }

    public int getScoreOfHand() {
        return this.isRoyalFlush();
    }

    private int isRoyalFlush() {
        return (this.numberOfConsecutiveCards ==5 && this.Suit_table.contains(5) && this.Rank_table.get(this.Rank_table.size()-1)>0) ? Rankings.RoyalFlush.getValue() : this.isStraightFlush();
    }

    private int isStraightFlush() {
        return (this.numberOfConsecutiveCards ==5 && this.Suit_table.contains(5)) ? Rankings.StraightFlush.getValue() : this.isFourofaKind();
    }

    private int isFourofaKind() {
        return (this.Rank_table.contains(4)) ? Rankings.FourofaKind.getValue() : this.isFullHouse();
    }

    private int isFullHouse() {
        return (this.Rank_table.contains(3) && this.Rank_table.contains(2)) ? Rankings.FullHouse.getValue() : this.isFlush();
    }

    private int isFlush() {
        return (this.Suit_table.contains(5)) ? Rankings.Flush.getValue() : this.isStraight();
    }

    private int isStraight() {
        return (this.numberOfConsecutiveCards ==5) ? Rankings.Straight.getValue() : this.isThreeofaKind();
    }

    private int isThreeofaKind() {
        return (this.Rank_table.contains(3)) ? Rankings.ThreeofaKind.getValue() : this.isTwoPair();
    }

    private int isTwoPair() {
        int count=0;
        for (Integer i: this.Rank_table) {
            if (i == 2) {
                count++;
            }
        }
        return (count==2) ? Rankings.TwoPair.getValue() : this.isPair();
    }

    private int isPair() {
        return (this.Rank_table.contains(2)) ? Rankings.Pair.getValue() : Rankings.HighCard.getValue();
    }

    public int getSubScoreOfHand() {
        return switch (this.getScoreOfHand()) {
            case 10 -> Rank.As.getValue();
            case 9, 6, 5, 1 -> this.subScoreOfHighCard();
            case 8 -> this.subscoreMethodN(4);
            case 7, 4 -> this.subscoreMethodN(3);
            case 3, 2 -> this.subscoreMethodN(2);
            default -> 0;
        };
    }

    private int subScoreOfHighCard() {
        return this.h.highestCard(this.h.getCards()).getForce();
    }

    private int subscoreMethodN(int n) {
        int temp=0;
        for (int i = 0; i < this.Rank_table.size(); i++) {
            if (this.Rank_table.get(i)==n) {
                temp = Math.max(temp,Rank.values()[i].getValue());
            }
        }
        return temp;
    }

    public int getScore() {
        return score;
    }

    public int getSubscore() {
        return subscore;
    }

    @Override
    public String toString() {
        return "{Suit_table=" + Suit_table + ", Rank_table=" + Rank_table + '}';
    }
}
