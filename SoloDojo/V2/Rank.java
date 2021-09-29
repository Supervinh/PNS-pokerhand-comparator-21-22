package SoloDojo.V2;

public enum Rank {
    Deux(2), Trois(3), Quatre(4), Cinq(5), Six(6), Sept(7), Huit(8), Neuf(9), Dix(10), Vallet(11), Damme(12), Roi(13), As(14);

    private int value;
    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void showValues() {
        Rank list[] = Rank.values();
        for (int i=0; i<list.length; i++) {
            System.out.println("The Value of "+ list[i] + " is " + list[i].value);
        }
    }
}