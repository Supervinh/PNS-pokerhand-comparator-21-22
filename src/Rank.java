/* Liste explicite des valeurs possibles associées à leur force
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */

public enum Rank {
    Deux(2), Trois(3), Quatre(4), Cinq(5), Six(6), Sept(7), Huit(8), Neuf(9), Dix(10), Valet(11), Dame(12), Roi(13), As(14);

    private final int value;
    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void showValues() {
        Rank[] list = Rank.values();
        for (Rank rank : list) {
            System.out.println("The Value of " + rank + " is " + rank.value);
        }
    }
}