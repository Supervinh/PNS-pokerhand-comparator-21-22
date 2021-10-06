import java.util.Optional;

public class Game {
   private Hand hand1, hand2;

    public Game(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Optional<Hand> compete(){
        if (this.hand1.highestCard().getValeur() < this.hand2.highestCard().getValeur()){
            return Optional.ofNullable(this.hand2);
        }
        else if (this.hand1.highestCard().getValeur() > this.hand2.highestCard().getValeur()){
            return Optional.ofNullable(this.hand1);
        }
        return Optional.empty();
    }

    public String toString(){
        return this.hand1 + "\n" + this.hand2;
    }
}
