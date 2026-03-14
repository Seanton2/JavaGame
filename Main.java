import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BattleManager bm = new BattleManager();
        bm.showBattleMenu(sc);
        sc.close();
    }
}