import java.util.*;

public class Hand {
    private ArrayList<Card> cartes;
    private static int playernumber = 0;
    private String nom = "Player ";

    public Hand(ArrayList<Card> cartes){
        this.cartes = cartes;
        Hand.playernumber++;
        this.nom += Hand.playernumber;
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
