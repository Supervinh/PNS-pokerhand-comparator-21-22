package SoloDojo.V2;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private int numberOfCards = 5;
    private Deck deck;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Integer> suitsOccurenceList;
    private ArrayList<Integer> rankOccurenceList;
    private int numberofConcecutiveCards;
    private int playerNumber;


    public Hand(Deck deck, Boolean manuel) {
        this.playerNumber = GameMaster.playerNumber++;
        this.deck = deck;
        System.out.print("Enter number of Cards: ");
        this.numberOfCards = GameMaster.CONSOLE.nextInt();
        GameMaster.CONSOLE.nextLine();
        if (!manuel) {
            this.setRandomCards();
        }
        else {
            this.setCards();
        }
        this.evaluateHand();
    }

    public Hand(Deck deck) {
        this.playerNumber = GameMaster.playerNumber++;
        this.deck = deck;
        this.setRandomCards();
        this.evaluateHand();
    }

    public void setCards() {
        for (int i = 0; i < this.numberOfCards; i++) {
            System.out.println("\nCard " + (i+1) + ": ");
            this.cards.add(this.deck.takeCard(new Card(GameMaster.typingRank(), GameMaster.typingSuit())));
        }
    }

    public void setRandomCards() {
        System.out.println("Generating Cards...\n");
        GameMaster.pause(500);
        for (int i = 0; i < this.numberOfCards; i++) {
            this.cards.add(this.deck.drawCard());
        }
    }

    public void evaluateHand() {
        this.rankOccurenceList = this.setRankOccurenceList();
        this.suitsOccurenceList = this.setSuitOccurenceList();
        this.numberofConcecutiveCards = this.setnumberofConcecutiveCards();
    }

    public ArrayList<Integer> setRankOccurenceList() {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            int sum = 0;
            for (Card card : this.cards) {
                if (card.getRank().equals(rank)) {
                    sum++;
                }
            }
            tempList.add(sum);
        }
        return tempList;
    }

    public ArrayList<Integer> setSuitOccurenceList() {
        int Coeur=0, Carreau=0, Pique=0, Treffle=0;
        for (Card card : this.cards) {
            if (card.getSuit().equals(Suit.Coeur)) {
                Coeur++;
            }
            if (card.getSuit().equals(Suit.Carreau)) {
                Carreau++;
            }
            if (card.getSuit().equals(Suit.Pique)) {
                Pique++;
            }
            if (card.getSuit().equals(Suit.Treffle)) {
                Treffle++;
            }
        }
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(Coeur);
        tempList.add(Carreau);
        tempList.add(Pique);
        tempList.add(Treffle);
        return tempList;
    }

    public int setnumberofConcecutiveCards() {
        ArrayList<Card> tempList = this.sortCards(this.cards);
        int concecutiveMax = 1;
        for (int i = 0; i < tempList.size()-1; i++) {
            int concecutiveMaxTemp = 1;
            for (int j = i+1; j < tempList.size(); j++) {
                if (tempList.get(i).getRank().getValue() == (tempList.get(j).getRank().getValue()-concecutiveMaxTemp)) {
                    concecutiveMaxTemp++;
                }
                else {
                    if (tempList.get(i).getRank().getValue() != (tempList.get(j).getRank().getValue()-concecutiveMaxTemp+1)) {
                        break;
                    }
                }
            }
            concecutiveMax = Math.max(concecutiveMax, concecutiveMaxTemp);
        }
        return concecutiveMax;
    }

    public ArrayList<Card> sortCards(ArrayList<Card> c) {
        Collections.sort(c, new CardComparator());
        return c;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Integer> getSuitsOccurenceList() {
        return suitsOccurenceList;
    }

    public ArrayList<Integer> getRankOccurenceList() {
        return rankOccurenceList;
    }

    public int getNumberofConcecutiveCards() {
        return numberofConcecutiveCards;
    }

    public String getPlayerNumber() {
        return "Player " + this.playerNumber;
    }

    @Override
    public String toString() {
        return "Player " + playerNumber + ": " + this.cards;
    }

    public int compareTo(Hand h) {
        int difference = Rankings.getScoreOfHand(this) - Rankings.getScoreOfHand(h);
        if (difference != 0) {
            return difference;
        }
        else {
            return Rankings.getSubScoreofHand(this) - Rankings.getSubScoreofHand(h);
        }
    }
}
