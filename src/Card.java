public class Card {
    private Rank symbole;
    private Suit couleur;
    private int valeur;

    public Card(Rank symbole, Suit couleur){
        this.symbole = symbole;
        this.couleur = couleur;
        this.valeur = this.symbole.getValue(); //on rentre sur l'entrée standard le symbole ainsi que la couleur de la carte.
                            //il faut cependant assigner une valeur chiffré à la carte comme 13 pour roi
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
