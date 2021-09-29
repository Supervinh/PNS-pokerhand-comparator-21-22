package SoloDojo.V1;

import java.util.ArrayList;

public class Classement {
    private ArrayList<Main> mains = new ArrayList<>();

    public Classement() {
    }

    public void ajoutMain(Main m) {
        this.mains.add(m);
    }

    public void evaluation() {
        int j = 0;
        int maxPoints = 0;
        for (int i=0; i < mains.size(); i++) {
            if (maxPoints < mains.get(i).getValeur()) {
                j = i;
                maxPoints = mains.get(i).getValeur();
            }
        }
        Main gagnant =  mains.get(j);
        System.out.println("\nLe Gagnant est la Main: " + gagnant.toString() + " avec " + gagnant.afficheValeurMain());

    }

}
