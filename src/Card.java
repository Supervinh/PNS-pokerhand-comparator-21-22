public class Card {
    private final Rank symbole;
    private final Suit couleur;
    private final int valeur;

    public Card(Rank r, Suit s){
        this.symbole = r;
        this.couleur = s;
        this.valeur = this.symbole.getValue();
    }

    public Rank getSymbole(){
        return this.symbole;
    }

    public Suit getCouleur(){
        return this.couleur;
    }

    public int getValeur(){
        return this.valeur;
    }

    public String toString(){
        return "[" + this.symbole + ", " + this.couleur + "]";
    }
}
