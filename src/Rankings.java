public enum Rankings {
    RoyalFlush(10), StraightFlush(9), FourofaKind(8), FullHouse(7), Flush(6), Straight(5), ThreeofaKind(4), TwoPair(3), Pair(2), HighCard(1);

    private final int value;
    Rankings(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }
}
