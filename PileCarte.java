package Dojo;

import java.util.ArrayList;
import java.util.Random;

public class PileCarte {
    private ArrayList<Carte> pile = new ArrayList<>();

    public PileCarte() {
        for (String s : Carte.getSymboles()) {
            for (String c : Carte.getCouleurs()) {
                pile.add(new Carte(s, c));
            }
        }
        
        Random rand = new Random();
        for (int i = 0; i < Math.max(5, rand.nextInt(10)); i++) {
            this.melangerPile();
        }
    }

    public void melangerPile() {
        Random rand = new Random();
        ArrayList<Carte> tempPile = new ArrayList<>();
        while (!this.pile.isEmpty()) {
            tempPile.add(this.pile.remove(rand.nextInt(this.pile.size())));
        }
        this.pile = tempPile;
    }

    public Carte piocheCarte() {
        if (!this.pile.isEmpty()) {
            return this.pile.remove(0);
        }
        return new Carte("Error", "Error");
    }

    public Carte prendCarte(Carte c) {
        if (!this.pile.isEmpty() && this.pile.contains(c)) {
            for (int i = 0; i < this.pile.size(); i++) {
                if (this.pile.get(i).equals(c)) {
                    this.pile.remove(i);
                }
            }
            return c;
        }
        return new Carte("Error", "Error");
    }


    public ArrayList<Carte> getPile() {
        return pile;
    }

    @Override
    public String toString() {
        return "Pile [" + pile + ", nbCarte=" + pile.size() + "]";
    }
}
