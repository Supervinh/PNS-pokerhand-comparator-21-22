package SoloDojo.V2;

import java.util.ArrayList;

public enum Rankings {
    RoyalFlush(10), StraightFlush(9), FourofaKind(8), FullHouse(7), Flush(6), Straight(5), ThreeofaKind(4), TwoPair(3), Pair(2), HighCard(1);

    private int value;
    Rankings(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    public static Rankings showHandRanking(Hand h) {
        int score = getScoreOfHand(h);
        for (Rankings rankings : Rankings.values()) {
            if (rankings.value == score) {
                return rankings;
            }
        }
        return Rankings.HighCard;
    }

    public static int isRoyalFlush(Hand h) {
        if (h.getNumberofConcecutiveCards() == 5 && h.getSuitsOccurenceList().contains(5)) {
            for (Card card : h.getCards()) {
                if (card.getRank().equals(Rank.As)) {
                    return RoyalFlush.value;
                }
            }
        }
        return isStraightFlush(h);
    }

    public static int isStraightFlush(Hand h) {
        return (h.getNumberofConcecutiveCards() == 5 && h.getSuitsOccurenceList().contains(5)) ? StraightFlush.value : isFourofaKind(h);
    }

    public static int isFourofaKind(Hand h) {
        return (h.getRankOccurenceList().contains(4)) ? FourofaKind.value : isFullHouse(h);
    }

    public static int isFullHouse(Hand h) {
        return (h.getRankOccurenceList().contains(3) && h.getRankOccurenceList().contains(2)) ? FullHouse.value : isFlush(h);
    }

    public static int isFlush(Hand h) {
        return (h.getSuitsOccurenceList().contains(5)) ? Flush.value : isStraight(h);
    }

    public static int isStraight(Hand h) {
        return (h.getNumberofConcecutiveCards() == 5) ? Straight.value : isThreeofaKind(h);
    }

    public static int isThreeofaKind(Hand h) {
        return (h.getRankOccurenceList().contains(3)) ? ThreeofaKind.value : isTwoPair(h);
    }

    public static int isTwoPair(Hand h) {
        int count=0;
        for (Integer integer : h.getRankOccurenceList()) {
            if (integer == 2) {
                count++;
            }
        }
        return (count >= 2) ? TwoPair.value : isPair(h);
    }

    public static int isPair(Hand h) {
        return (h.getRankOccurenceList().contains(2)) ? Pair.value : HighCard.value;
    }

    public static int getScoreOfHand(Hand h) {
        return isRoyalFlush(h);
    }

    public static int subScoreOfRoyalFlush() {
        return 0;
    }

    public static int subScoreOfStraightFlush(Hand h) {
        return subScoreOfHighCard(h);
    }

    public static int subScoreOfFourofaKind(Hand h) {
        ArrayList<Card> cards = h.getCards();
        for (int i = 0; i < cards.size()-1; i++) {
            if (cards.get(i).getRank().getValue() == cards.get(i+1).getRank().getValue()) {
                return cards.get(i).getRank().getValue();
            }
        }
        return 0;
    }

    public static int subScoreOfFullHouse(Hand h) {
        ArrayList<Card> cards = h.getCards();
        int sum=0;
        for (int i = 0; i < cards.size()-1; i++) {
            if (cards.get(i).getRank() == cards.get(i+1).getRank()) {
                sum++;
            }
            else {
                sum = 0;
            }
            if (sum == 2) {
                return cards.get(i).getRank().getValue();
            }
        }
        return 0;
    }

    public static int subScoreOfFlush(Hand h) {
        return subScoreOfHighCard(h);
    }

    public static int subScoreOfStraight(Hand h) {
        return subScoreOfHighCard(h);
    }
    
    public static int subScoreOfThreeofaKind(Hand h) {
        ArrayList<Card> cards = h.getCards();
        for (int i = 0; i < cards.size()-1; i++) {
            if (cards.get(i).getRank().getValue() == cards.get(i+1).getRank().getValue()) {
                return cards.get(i).getRank().getValue();
            }
        }
        return 0;
    }

    public static int subScoreOfTwoPair(Hand h) {
        int value=0;
        ArrayList<Card> cards = h.getCards();
        for (int i = 0; i < cards.size()-1; i++) {
            if (cards.get(i).getRank().equals(cards.get(i+1).getRank())) {
                value = Math.max(value, cards.get(i).getRank().getValue());
            }
        }
        return value;
    }

    public static int subScoreOfPair(Hand h) {
        ArrayList<Card> cards = h.getCards();
        for (int i = 0; i < cards.size()-1; i++) {
            if (cards.get(i).getRank().getValue() == cards.get(i+1).getRank().getValue()) {
                return cards.get(i).getRank().getValue();
            }
        }
        return 0;
    }

    public static int subScoreOfHighCard(Hand h) {
        ArrayList<Card> cards = h.getCards();
        return cards.get(cards.size()-1).getRank().getValue();
    }

    public static int getSubScoreofHand(Hand h) {
        switch (Rankings.getScoreOfHand(h)) {
            case 10:
                return subScoreOfRoyalFlush();
            case 9:
                return subScoreOfStraightFlush(h);
            case 8:
                return subScoreOfFourofaKind(h);
            case 7:
                return subScoreOfFullHouse(h);
            case 6:
                return subScoreOfFlush(h);
            case 5:
                return subScoreOfStraight(h);
            case 4:
                return subScoreOfThreeofaKind(h);
            case 3:
                return subScoreOfTwoPair(h);
            case 2:
                return subScoreOfPair(h);
            case 1:
                return subScoreOfHighCard(h);
            default:
                return 0;
        }
    }
}
