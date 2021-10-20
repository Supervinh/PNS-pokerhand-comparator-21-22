/**
 * Liste explicite des combinaisons possibles associées à une valeur
 *
 * @Author Matis Herrmann
 * @Author Louis Hattiger
 * @Author Vinh Faucher
 */

public enum Rankings {
    RoyalFlush(10), StraightFlush(9), FourOfAKind(8), FullHouse(7), Flush(6), Straight(5), ThreeOfAKind(4), TwoPair(3), Pair(2), HighCard(1);

    private final int value;
    Rankings(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }
}
