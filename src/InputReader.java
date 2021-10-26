import java.util.*;

/**
 * Classe permettant de faire des entrées sur claviers dans le Terminal et les vérifier.
 *
 * @author Matis Herrmann
 * @author Louis Hattiger
 * @author Vinh Faucher
 */
public class InputReader {
    // Scanner en tant que variable static afin de pouvoir l'utiliser quand on veut.
    public static final Scanner CONSOLE = new Scanner(System.in);

    /**
     * Entrer une main complete au terminal d'un seul coup, puis on identifie et sépare les cartes saisies pour
     * les stocker dans une liste de string de carte.
     *
     * @return La method typingCard(). Avec comme paramètre une liste de string de toutes les cartes.
     */
    public static ArrayList[] typingHand() {
        ArrayList<String> handsTextList = new ArrayList<>();
        String input = CONSOLE.nextLine();
        Collections.addAll(handsTextList, input.split("\\s+"));
        return typingCard(handsTextList);
    }

    /**
     * Depuis un string composé du symbole et couleur, on les identifie et les sépare dans des listes différentes.
     *
     * @param card Liste de string de cartes.
     * @return Une liste composée d'une liste de symbole et une liste de couleur.
     */
    public static ArrayList[] typingCard(ArrayList<String> card) {
        ArrayList<String> ranks = new ArrayList<>();
        ArrayList<String> suits = new ArrayList<>();
        for (String s : card) {
            String[] cardText = s.toLowerCase().split("(?=\\D+)(?)", 2);
            ranks.add(cardText[0]);
            suits.add(cardText[1]);
        }
        return new ArrayList[]{ranks, suits};
    }

    /**
     * @return La methode typingRank() avec comme paramètre le String entré.
     */
    public static Rank typingRank() {
        System.out.print("Enter Rank: ");
        String input = CONSOLE.nextLine();
        return typingRank(input);
    }

    /**
     * Permet de checker si input est en accordance avec les inputs voulus. Sinon il relance la method typingRank().
     *
     * @param input String du symbole.
     * @return Le Enum de la class Rank qui a pour nom input.
     */
    public static Rank typingRank(String input) {
        switch (input.toLowerCase()) {
            case "2", "deux", "two" -> input = "Two";
            case "3", "trois", "three" -> input = "Three";
            case "4", "quatre", "four" -> input = "Four";
            case "5", "cinq", "five" -> input = "Five";
            case "6", "six" -> input = "Six";
            case "7", "sept", "seven" -> input = "Seven";
            case "8", "huit", "eight" -> input = "Eight";
            case "9", "neuf", "nine" -> input = "Nine";
            case "10", "dix", "ten" -> input = "Ten";
            case "11", "v", "j", "valet", "jack" -> input = "Jack";
            case "12", "d", "q", "dame", "queen" -> input = "Queen";
            case "13", "r", "k", "roi", "king" -> input = "King";
            case "1", "a", "as", "ace" -> input = "Ace";
            default -> {
            }
        }
        try {
            return Rank.valueOf(input);
        } catch (Exception e) {
            System.out.println(e);
            return typingRank();
        }
    }

    /**
     * @return La methode typingSuit() avec comme paramètre le String entré.
     */
    public static Suit typingSuit() {
        System.out.print("Enter Suit: ");
        String input = CONSOLE.nextLine();
        return typingSuit(input);
    }

    /**
     * Permet de checker si input est en accordance avec les inputs voulus. Sinon il relance la method typingSuit().
     *
     * @param input String de la couleur.
     * @return Le Enum de la class Suit qui a pour nom input.
     */
    public static Suit typingSuit(String input) {
        switch (input.toLowerCase()) {
            case "co", "coeur", "heart" -> input = "Coeur";
            case "ca", "carreau", "diamond" -> input = "Carreau";
            case "pi", "pique", "spade" -> input = "Pique";
            case "tr", "trefle", "club" -> input = "Trefle";
            default -> {
            }
        }
        try {
            return Suit.valueOf(input);
        } catch (Exception e) {
            System.out.println(e);
            return typingSuit();
        }
    }
}
