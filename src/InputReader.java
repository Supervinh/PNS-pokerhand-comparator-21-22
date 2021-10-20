import java.util.*;

public class InputReader {
    public static final Scanner CONSOLE = new Scanner(System.in);

    public static ArrayList[] typingHand() {
        ArrayList<String> handsTextList = new ArrayList<>();
        String input = CONSOLE.nextLine();
        Collections.addAll(handsTextList, input.split("\\s+"));
        return typingCard(handsTextList);
    }

    public static ArrayList[] typingCard(ArrayList<String> card) {
        ArrayList<String> ranks = new ArrayList<>();
        ArrayList<String> suits = new ArrayList<>();
        for (String s: card) {
            String[] cardText = s.toLowerCase().split("(?=\\D+)(?)", 2);
            ranks.add(cardText[0]);
            suits.add(cardText[1]);
        }
        return new ArrayList[]{ranks, suits};
    }

    public static Rank typingRank() {
        System.out.print("Enter Rank: ");
        String input = CONSOLE.nextLine();
        return typingRank(input);
    }

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
