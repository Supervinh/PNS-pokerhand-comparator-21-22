package SoloDojo.Slices;

public class Game {
   private Hand hand1, hand2;

    public Game(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand compete(){
        if (this.hand1.getCards().get(0).getForce() > this.hand2.getCards().get(0).getForce()){
            return this.hand1;
        }
        return this.hand2;
    }


    public String toString(){
        return this.hand1 + "\n" + this.hand2;
    }
}
