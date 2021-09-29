package SoloDojo.V1;

import java.util.Arrays;

public class Carte {
    private int force;
    private String symbole;
    private String couleur;
    private static String[] couleurs = {"Coeur", "Carreau", "Pique", "Treffle"};
    private static String[] symboles = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "V", "D", "R", "A"};

    public Carte(String symbole, String couleur) {
        symbole = formatSymbole(symbole);
        couleur = formatCouleur(couleur);
        if (this.isSymbole(symbole)) {
            this.symbole = symbole;
        }
        else {
            System.out.println("Veulez entrez une valeur de ce Tableau: " + Arrays.toString(getSymboles()));
            System.exit(0);
        }
        
        if (this.isCouleur(couleur)) {
            this.couleur = couleur;
        }
        else {
            System.out.println("Veulez entrez une valeur de ce Tableau: " + Arrays.toString(getCouleurs()));
            System.exit(0);
        }

        this.force = this.setForce();
    }

    public boolean isSymbole(String symb) {
        for (String string : getSymboles()) {
            if (string.toUpperCase().equals(symb.toUpperCase())) {
                return true;
            }
        }
        System.out.println("Le Symbole '" + symb + "' n'est pas Valide");
        return false;
    }

    public boolean isCouleur(String coul) {
        for (String string : getCouleurs()) {
            if (string.toUpperCase().equals(coul.toUpperCase())) {
                return true;
            }
        }
        System.out.println("La Couleur '" + coul + "' n'est pas Valide");
        return false;
    }

    public int getForce() {
        return force;
    }

    public String formatSymbole(String s) {
        switch (s.toUpperCase().substring(0,1)) {
            case "1":
                if (s.length()>1) {
                    if (s.toUpperCase().substring(0,2).equals("10")) {
                        return "10";
                    }
                    return s;
                }
                else {
                    return "A";
                }
            case "2":
                return "2";
            case "3":
                return "3";
            case "4":
                return "4";
            case "5":
                return "5";
            case "6":
                return "6";
            case "7":
                return "7";
            case "8":
                return "8";
            case "9":
                return "9";
            case "V":
            case "J":
                return "V";
            case "D":
            case "Q":
                return "D";
            case "R":
            case "K":
                return "R";
            case "A":
                return "A";
            default:
                return s;
        }
    }
    
    private String formatCouleur(String c) {
        if (c.length()>1) {
            switch (c.toUpperCase().substring(0, 2)) {
                case "CO":
                    return "Coeur";
                case "CA":
                    return "Carreau";
                case "PI":
                    return "Pique";
                case "TR":
                    return "Treffle";
                default:
                    return c;
            }
        }
        return c;
    }
        
    public int setForce() {
        switch (this.symbole.toUpperCase()) {
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
            case "V":
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

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    static String[] getCouleurs() {
        return couleurs;
    }

    static String[] getSymboles() {
        return symboles;
    }

    @Override
    public String toString() {
        return "[" + symbole + ", " + couleur + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carte other = (Carte) obj;
        if (couleur == null) {
            if (other.couleur != null)
                return false;
        } else if (!couleur.equals(other.couleur))
            return false;
        if (symbole == null) {
            if (other.symbole != null)
                return false;
        } else if (!symbole.equals(other.symbole))
            return false;
        return true;
    }   

    
}
