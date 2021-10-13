import java.util.*;

public class Combinaison {
    private final Hand h;
    private final ArrayList<Integer> Suit_table = new ArrayList<>();
    private final ArrayList<Integer> Rank_table = new ArrayList<>();
    private final int numberOfConcecutiveCards;
    private final int score;
    private final int subscore;


    public Combinaison (Hand h){
        this.h = h;
        this.setSuit_table();
        this.setRank_table();
        this.score = this.getScoreOfHand(h);
        this.subscore = this.getSubScoreOfHand(h);
        this.numberOfConcecutiveCards = this.consecutiveCards();
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

    public Rankings showHandRanking(Hand h) {
        for (Rankings rankings : Rankings.values()) {
            if (rankings.getValue() == this.score) {
                return rankings;
            }
        }
        return Rankings.HighCard;
    }

    public int getScoreOfHand(Hand h) {
        return isRoyalFlush(h);
    }

    private int isRoyalFlush(Hand h) {
        return (this.numberOfConcecutiveCards==5 && this.Suit_table.contains(5) && this.Rank_table.get(this.Rank_table.size()-1)>0) ? Rankings.RoyalFlush.getValue() : this.isStraightFlush(h);
    }

    private int isStraightFlush(Hand h) {
        return (this.numberOfConcecutiveCards==5 && this.Suit_table.contains(5)) ? Rankings.StraightFlush.getValue() : this.isFourofaKind(h);
    }

    private int isFourofaKind(Hand h) {
        return (this.Rank_table.contains(4)) ? Rankings.FourofaKind.getValue() : this.isFullHouse(h);
    }

    private int isFullHouse(Hand h) {
        return (this.Rank_table.contains(3) && this.Rank_table.contains(2)) ? Rankings.FullHouse.getValue() : this.isFlush(h);
    }

    private int isFlush(Hand h) {
        return (this.Suit_table.contains(5)) ? Rankings.Flush.getValue() : this.isStraight(h);
    }

    private int isStraight(Hand h) {
        return (this.numberOfConcecutiveCards==5) ? Rankings.Straight.getValue() : this.isThreeofaKind(h);
    }

    private int isThreeofaKind(Hand h) {
        return (this.Rank_table.contains(3)) ? Rankings.ThreeofaKind.getValue() : this.isTwoPair(h);
    }

    private int isTwoPair(Hand h) {
        int count=0;
        for (Integer i: this.Rank_table) {
            if (i == 2) {
                count++;
            }
        }
        return (count==2) ? Rankings.TwoPair.getValue() : this.isPair(h);
    }

    private int isPair(Hand h) {
        return (this.Rank_table.contains(2)) ? Rankings.Pair.getValue() : Rankings.HighCard.getValue();
    }

    public int getSubScoreOfHand(Hand h) {
        return switch (this.getScoreOfHand(h)) {
            case 10 -> subScoreOfRoyalFlush();
//            case 9 -> subScoreOfStraightFlush(h);
//            case 8 -> subScoreOfFourofaKind(h);
//            case 7 -> subScoreOfFullHouse(h);
//            case 6 -> subScoreOfFlush(h);
//            case 5 -> subScoreOfStraight(h);
//            case 4 -> subScoreOfThreeofaKind(h);
//            case 3 -> subScoreOfTwoPair(h);
//            case 2 -> subScoreOfPair(h);
//            case 1 -> subScoreOfHighCard(h);
            default -> 0;
        };
    }
    
    
    
    

    private int subScoreOfRoyalFlush() {
        return 0;
    }


    

    public ArrayList<Integer> getSuit_table() {
        return Suit_table;
    }

    public ArrayList<Integer> getRank_table() {
        return Rank_table;
    }

    public int getScore() {
        return score;
    }

    public int getSubscore() {
        return subscore;
    }

    public int getNumberOfConcecutiveCards() {
        return numberOfConcecutiveCards;
    }

    @Override
    public String toString() {
        return "{Suit_table=" + Suit_table + ", Rank_table=" + Rank_table + '}';
    }
}
