import java.util.List;

public class Display {
    public void showBattlefield(List<Combatant> t1, List<Combatant> t2) {
        System.out.println("\n================ STATUS ================");
        for (Combatant c : t1) renderStats(c);
        System.out.println("---------------- VS ----------------");
        for (Combatant c : t2) renderStats(c);
        System.out.println("========================================");
    }

    private void renderStats(Combatant c) {
        String status = c.isAlive() ? "" : " [FALLEN]";
        System.out.printf("%-12s | HP: %d/%d | MP: %d/%d%s%n", 
            c.getName(), c.getHealth(), c.getMaxHealth(), c.getMana(), c.getMaxMana(), status);
    }
}