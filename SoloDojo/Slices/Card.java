package SoloDojo.Slices;

public class Card {
    private int force;

    public Card(int force) {
        if (force > 0 && force < 15) {
            if (force == 1) {
                force = 14;
            }
            this.force = force;
        }
        else {
            System.out.println("Error: " + force + " is not between 1 & 14");
            System.exit(1);
        }
        this.force = force;
    }

    @Override
    public String toString() {
        return "[force=" + force + "]";
    }

    public int getForce() {
        return force;
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
        if (force != other.force)
            return false;
        return true;
    }

    public int compareTo(Card c2) {
        return this.getForce()-c2.getForce();
    }
}
