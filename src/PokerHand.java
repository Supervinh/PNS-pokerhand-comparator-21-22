public class PokerHand {
    public static void main(String [] args){
        Card carte1 = new Card("Tr", "J");
        Card carte2 = new Card("Co", "2");
        Hand main1 = new Hand(carte1, "Main 1");
        Hand main2 = new Hand(carte2, "Main 2");
        Game game = new Game(main1, main2);
        System.out.println(game);

    }
}
