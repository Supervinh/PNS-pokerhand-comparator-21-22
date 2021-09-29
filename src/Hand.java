import java.util.*;

public class Hand {
    private Card carte;
    //private ArrayList<Card> cartes;
    private String nom;

    public Hand(Card carte, String nom){
        this.carte = carte;
        this.nom = nom;
    }

    public Card getCarte() {
        return carte;
    }

    public String toString(){
        return this.nom + " : " + this.carte;
    }
}
