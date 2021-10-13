import java.util.*;

public class InputReader {
    public static final Scanner CONSOLE = new Scanner(System.in);

    public static Rank typingRank() {
        System.out.print("Enter Rank: ");
        String input = CONSOLE.nextLine();
        return typingRank(input);
    }

    public static Rank typingRank(String input) {
        switch (input.toLowerCase()) {
            case "2", "deux", "two" -> input = "Deux";
            case "3", "trois", "three" -> input = "Trois";
            case "4", "quatre", "four" -> input = "Quatre";
            case "5", "cinq", "five" -> input = "Cinq";
            case "6", "six" -> input = "Six";
            case "7", "sept", "seven" -> input = "Sept";
            case "8", "huit", "eight" -> input = "Huit";
            case "9", "neuf", "nine" -> input = "Neuf";
            case "10", "dix", "ten" -> input = "Dix";
            case "11", "v", "j", "valet", "jack" -> input = "Valet";
            case "12", "d", "q", "dame", "queen" -> input = "Dame";
            case "13", "r", "k", "roi", "king" -> input = "Roi";
            case "1", "a", "as", "ace" -> input = "As";
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

    public static Suit typingSuit(){
        System.out.print("Enter Suit: ");
        String input = CONSOLE.nextLine();
        return typingSuit(input);
    }

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
