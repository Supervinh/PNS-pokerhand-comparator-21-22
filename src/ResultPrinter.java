import java.util.*;

import static javax.swing.UIManager.get;

public class ResultPrinter {
    static public void showResult (Optional<Hand> h){
        if (get(h).isEmpty()){
            System.out.println("There is equality between the two hands");
        }
        else {
            System.out.println("The Winner is" + h);
        }
    }
}
