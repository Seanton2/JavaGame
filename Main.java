import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Initialize the flow controller
        BattleManager gameFlow = new BattleManager();

        // Connect the interface and start
        gameFlow.showBattleMenu(sc);

        System.out.println("Game closed.");
        sc.close();
    }
}