import java.util.Optional;

public class ResultPrinter {
    static public void showResult (Optional<Hand> h){
        if (h.isEmpty()){
            System.out.println("There is equality between the two hands");
        }
        else {
            System.out.println("The Winner is" + h);
        }
    }
}
