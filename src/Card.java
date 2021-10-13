public class Card {
    private final Rank rank;
    private final Suit suit;
    private final int force;

    public Card(Rank r, Suit s){
        this.rank = r;
        this.suit = s;
        this.force = this.rank.getValue();
    }

    public Rank getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public int getForce(){
        return this.force;
    }

    public String toString(){
        return "[" + this.rank + ", " + this.suit + "]";
    }

    public int compareTo(Card c2) {
        return this.getForce()-c2.getForce();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        return suit == other.suit;
    }
}
