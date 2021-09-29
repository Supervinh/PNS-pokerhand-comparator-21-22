public class Card {
    private String couleur;
    private String symbole;
    private int valeur;

    public Card(String couleur, String symbole){
        this.couleur = couleur;
        this.symbole = symbole;
        this.valeur = this.setValeur(); //on rentre sur l'entrée standard le symbole ainsi que la couleur de la carte.
                            //il faut cependant assigner une valeur chiffré à la carte comme 13 pour roi
    }

    private int setValeur(){
        switch (this.symbole){
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "D":
                return 12;
            case "R":
                return 13;
            case "A":
                return 14;
            default:
                return -1;
        }
    }

    public String getSymbole(){
        return this.symbole;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public int getValeur(){
        return this.valeur;
    }

    public String toString(){
        return this.symbole + this.couleur;
    }
}
