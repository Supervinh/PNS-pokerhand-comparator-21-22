package SoloDojo.V1;

public class Run {

    static public void pause(int Microseconds) {
        try {
            java.util.concurrent.TimeUnit.MILLISECONDS.sleep(Microseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public void clearCmd() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    static public void print(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        // Constants //
        int nombre2Carte = 5;
        PileCarte pile = new PileCarte();

        // GameMaster //
        Run.clearCmd();
        System.out.println("##### Dojo - Main de poker #####\n");
        Run.pause(500);

        print("J1 - Entrez Votre Main: ");
        Main mainJ1 = new Main(nombre2Carte, false, pile);

        Run.clearCmd();
        print("CPU - Entrez Votre Main: ");
        Main mainCPU = new Main(nombre2Carte, true, pile);

        Run.clearCmd();
        System.out.println(mainJ1.toString() + " : " + mainJ1.afficheValeurMain());

        System.out.println(mainCPU.toString() + " : " + mainCPU.afficheValeurMain());


        Classement classement = new Classement();
        classement.ajoutMain(mainJ1);
        classement.ajoutMain(mainCPU);
        classement.evaluation();

        //System.out.println("\n" + pile);
        
    }
}
