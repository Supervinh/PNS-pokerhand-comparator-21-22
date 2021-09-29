package SoloDojo.Slices.Slice_1;

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
}
