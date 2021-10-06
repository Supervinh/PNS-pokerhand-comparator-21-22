import java.util.*;

public class Hand {
    private ArrayList<Card> cartes;
    private String nom;

    public Hand(ArrayList<Card> cartes, String nom){
        this.cartes = cartes;
        this.nom = nom;
    }

    public Card highestCard(){
        int max = -1, place = 0, force = 0;
        for (int i = 0; i < this.cartes.size(); i++){
            force = this.cartes.get(i).getValeur();
            if (max < force){
                max = force;
                place = i;
            }
        }
        return this.cartes.get(place);
    }

    public ArrayList<Card> getCarte() {
        return this.cartes;
    }

    public String toString(){
        return this.nom + " : " + this.cartes;
    }
}
