package SoloDojo.V1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private int nombre2Carte;
    private ArrayList<Carte> cartes = new ArrayList<>();
    private PileCarte pile;
    private int valeur = 0;
    //private int nombreCarteConsecutif;
    //private int nombreOccurenceCouleur;
    //private int nombreCarteForce;

    public Main(int nombre2Carte, boolean aléa, PileCarte pile) {
        this.nombre2Carte = nombre2Carte;
        this.pile = pile;
        if (aléa) {
            this.setRandCartes();
        }
        else {
            this.setCartes();
        }
        this.valeur = this.setScore2Main();
    }

    public void setCartes() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.nombre2Carte; i++) {
            System.out.println("Carte " + (i+1) + ":");
            String s, c;
            System.out.print("Symbole: ");
            s = sc.nextLine();
            System.out.print("Couleur: ");
            c = sc.nextLine();
            Carte C = this.pile.prendCarte(new Carte(s, c));
            this.cartes.add(C);
        }
        sc.close();
    }

    public void setRandCartes() {
        System.out.println("Generation de Cartes Aléatoire...\n");
        Run.pause(1000);
        for (int i = 0; i < this.nombre2Carte; i++) {
            this.cartes.add(this.pile.piocheCarte());
        }
    }

    public ArrayList<Integer> nombreOccurenceForce() {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (String s : Carte.getSymboles()) {
            int somme = 0;
            for (Carte carte : cartes) {
                if (carte.getSymbole().equals(s)) {
                    somme++;
                }
            }
            tempList.add(somme);
        }
        return tempList;
    }

    public ArrayList<Integer> nombreOccurenceCouleur() {
        int Coeur = 0, Carreau = 0, Pique = 0, Treffle = 0;
        for (Carte carte : cartes) {
            if (carte.getCouleur().equals("Coeur")) {
                Coeur++;
            }
            if (carte.getCouleur().equals("Carreau")) {
                Carreau++;
            }
            if (carte.getCouleur().equals("Pique")) {
                Pique++;
            }
            if (carte.getCouleur().equals("Treffle")) {
                Treffle++;
            }
        }
        ArrayList<Integer> occList = new ArrayList<>();
        occList.add(Coeur);
        occList.add(Carreau);
        occList.add(Pique);
        occList.add(Treffle);
        return occList;
    }

    public int nombreConsecutif() {
        ArrayList<Carte> tempList = this.classerCartes(this.cartes);
        int consMax = 1;
        for (int i = 0; i < tempList.size()-1 ; i++) {
            int consMaxTemp = 1;
            for (int j = i+1; j < tempList.size(); j++) {
                if (tempList.get(i).getForce() == (tempList.get(j).getForce()-consMaxTemp)) {
                    consMaxTemp++;
                }
                else {
                    if (tempList.get(i).getForce() != (tempList.get(j).getForce()-consMaxTemp+1)) {
                        break;
                    }
                }
            }
            consMax = Math.max(consMax, consMaxTemp);
        }
        return consMax;
    }

    public boolean isClasser(ArrayList<Carte> c) {
        for (int i = 0; i < c.size()-1; i++) {
            for (int j = i+1; j < c.size(); j++) {
                if (c.get(i).getForce() > c.get(j).getForce()) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Carte> classerCartes(ArrayList<Carte> c) {
        ArrayList<Carte> tempCartes = new ArrayList<>();
        tempCartes.add(c.get(0));

        for (int i = tempCartes.size(); i < c.size(); i++) {
            int force = c.get(i).getForce();
            int j = 0;
            for (j = 0; j < tempCartes.size(); j++) {
                if (force < c.get(j).getForce()) {
                    break;
                }
            }
            tempCartes.add(j, c.get(i));
        }
        return tempCartes;
    }

    public boolean isQuinteFlush() {
        return this.nombreOccurenceCouleur().contains(5) && this.nombreConsecutif() >= 5;
    }

    public boolean isCarre() {
        return this.nombreOccurenceForce().contains(4);
    }

    public boolean isFull() {
        return this.nombreOccurenceForce().contains(3) && this.nombreOccurenceForce().contains(2);
    }

    public boolean isCouleur() {
        return this.nombreOccurenceCouleur().contains(5);
    }

    public boolean isSuite() {
        return this.nombreConsecutif() >= 5;
    }

    public boolean isBrelan() {
        return this.nombreOccurenceForce().contains(3);
    }

    public boolean isDoublePair() {
        int count = 0;
        for (Integer integer : this.nombreOccurenceForce()) {
            if (integer == 2) {
                count++;
            }
        }
        return count >= 2;
    }

    public boolean isPair() {
        return this.nombreOccurenceForce().contains(2);
    }

    public boolean isSimple() {
        for (int i = 0; i < cartes.size(); i++) {
            for (int j = i+1; j < cartes.size(); j++) {
                if (cartes.get(i).getSymbole() == cartes.get(j).getSymbole()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int setScore2Main() {
        if (this.isQuinteFlush()) {
            return 9;
        } else {
            if (this.isCarre()) {
                return 8;
            } else {
                if (this.isFull()) {
                    return 7;
                } else {
                    if (this.isCouleur()) {
                        return 6;
                    } else {
                        if (this.isSuite()) {
                            return 5;
                        } else {
                            if (this.isBrelan()) {
                                return 4;
                            } else {
                                if (this.isDoublePair()) {
                                    return 3;
                                } else {
                                    if (this.isPair()) {
                                        return 2;
                                    } else {
                                        if (this.isSimple()) {
                                            return 1;
                                        } else {
                                            return -1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public String afficheValeurMain() {
        switch (this.valeur) {
            case 9:
               return "une Quinte Flush";
            case 8:
                return "un Carré";
            case 7:
                return "un Full";
            case 6:
               return "une Couleur";
            case 5:
                return "une Suite";
            case 4:
                return "un Brelan";
            case 3:
                return "une Double Pair";
            case 2:
                return "une Pair";
            case 1:
                return "un Simple";
            default:
                return "Error";
        }
    }

    public int getNombre2Carte() {
        return nombre2Carte;
    }

    public void setNombre2Carte(int nombre2Carte) {
        this.nombre2Carte = nombre2Carte;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return nombre2Carte + " cartes = " + cartes;
    }

    

    
}
