package SoloDojo.V2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameMaster {

    public static final Scanner CONSOLE = new Scanner(System.in);

    public static int playerNumber = 1;

    static public void clearCmd() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    static public void pause(int Microseconds) {
        try {
            java.util.concurrent.TimeUnit.MILLISECONDS.sleep(Microseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static Rank typingRank() {
        System.out.print("Enter Rank: ");
        String input = CONSOLE.nextLine();
        switch (input.toLowerCase()) {
            case "2":
            case "deux":
            case "two":
                input = "Deux";
                break;
            case "3":
            case "trois":
            case "three":
                input = "Trois";
                break;
            case "4":
            case "quatre":
            case "four":
                input = "Quatre";
                break;
            case "5":
            case "cinq":
            case "five":
                input = "Cinq";
                break;
            case "6":
            case "six":
                input = "Six";
                break;
            case "7":
            case "sept":
            case "seven":
                input = "Sept";
                break;
            case "8":
            case "huit":
            case "eight":
                input = "Huit";
                break;
            case "9":
            case "neuf":
            case "nine":
                input = "Neuf";
                break;
            case "10":
            case "dix":
            case "ten":
                input = "Dix";
                break;
            case "11":
            case "v":
            case "vallet":
            case "jack":
                input = "Vallet";
                break;
            case "12":
            case "d":
            case "damme":
            case "queen":
                input = "Damme";
                break;
            case "13":
            case "r":
            case "roi":
            case "king":
                input = "Roi";
                break;
            case "1":
            case "a":
            case "as":
            case "ace":
                input = "As";
                break;            
            default:
                break;
        }

        try {
            return Rank.valueOf(input);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
            return Rank.As;
        }
    }

    public static Suit typingSuit() {
        System.out.print("Enter Suit: ");
        String input = CONSOLE.nextLine();
        switch (input.toLowerCase()) {
            case "co":
            case "coeur":
            case "heart":
                input = "Coeur";
                break;
            case "ca":
            case "carreau":
            case "diamond":
                input = "Carreau";
                break;
            case "pi":
            case "pique":
            case "spade":
                input = "Pique";
                break;
            case "tr":
            case "treffle":
            case "club":
                input = "Treffle";
                break;
        
            default:
                break;
        }

        try {
            return Suit.valueOf(input);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
            return Suit.Coeur;
        }
    }

    public static ArrayList<Hand> setPlayersAuto(int n, Deck d) {
        ArrayList<Hand> temList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\nPlayer " + (i+1) + ": ");
            temList.add(new Hand(d));
        }
        return temList;
    }

    public static ArrayList<Hand> setPlayersMan(int n, Deck d) {
        ArrayList<Hand> temList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\nPlayer " + (i+1) + ": ");
            temList.add(new Hand(d, true));
        }
        return temList;
    }

    public static void ShowWinner(ArrayList<Hand> hands) {
        if (!hands.isEmpty()) {
            Collections.sort(hands, new HandComparator());
            ArrayList<Hand> winners = new ArrayList<>();
            int winnerScore = Rankings.getScoreOfHand(hands.get(hands.size()-1));
            for (Hand hand : hands) {
                if (Rankings.getScoreOfHand(hand) == winnerScore && Rankings.getSubScoreofHand(hand) == Rankings.getSubScoreofHand(hands.get(hands.size()-1))) {
                    winners.add(hand);
                }
            }
            if (winners.size() == 1) {
                System.out.println("\nThe Winner is " + winners.get(0).getPlayerNumber() + " with a '" + Rankings.showHandRanking(winners.get(0)) + "'");
            }
            else {
                System.out.println("\nDraw - " + winners.size() + " Winners won with a '" + Rankings.showHandRanking(winners.get(0)) + "'");
                for (int i=0; i<winners.size(); i++) {
                    System.out.println(winners.get(i).getPlayerNumber());
                }
            }
        }
    }


    public static void main(String[] args) {
        /* ##### Settings up Game ##### */
        Deck deck = new Deck();
        GameMaster.clearCmd();
        System.out.println("########## Dojo Poker Hands ##########");

        /* ##### Starting Game ##### */
        System.out.print("\nEnter Number of Players: ");
        int numberofPlayers = CONSOLE.nextInt();
        ArrayList<Hand> players = setPlayersAuto(numberofPlayers, deck);
        //ArrayList<Hand> players = setPlayersMan(numberofPlayers, deck);
        for (Hand hand : players) {
            System.out.println(hand + " => " + Rankings.showHandRanking(hand));
        }
        ShowWinner(players);
    }
}