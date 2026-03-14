import java.util.List;
 
public class TurnOrder {
    private int currentIndex = 0;
 
    public Combatant getNextCombatant(List<Combatant> participants) {
        if (participants.isEmpty()) return null;
        if (currentIndex >= participants.size()) currentIndex = 0;
        return participants.get(currentIndex++);
    }
 
    public void reset() { currentIndex = 0; }
}
 
________________________
 
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BattleManager bm = new BattleManager();
        bm.showBattleMenu(sc);
        sc.close();
    }
}