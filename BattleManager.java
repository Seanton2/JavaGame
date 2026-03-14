import java.util.*;
 
public class BattleManager {
    private TurnOrder turnOrder;
    private Display display = new Display();
 
    public BattleManager() { this.turnOrder = new TurnOrder(); }
 
    public void showBattleMenu(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- BATTLE SYSTEM ---");
            System.out.println("1. PvP (1v1)\n2. AI vs Player\n3. PvE (2v1)\n4. PvP (2v2)\n0. Exit");
            System.out.print("Choice: ");
            int choice = sc.hasNextInt() ? sc.nextInt() : 0;
            if (sc.hasNextLine()) sc.nextLine();
 
            switch (choice) {
                case 1 -> startMatch(createTeam("P1", 1, false), createTeam("P2", 1, false), sc);
                case 2 -> startMatch(createTeam("Player", 1, false), createTeam("AI", 1, true), sc);
                case 3 -> startMatch(createTeam("P", 2, false), createTeam("AI", 1, true), sc);
                case 4 -> startMatch(createTeam("P", 2, false), createTeam("Enemy P", 2, false), sc);
                case 0 -> running = false;
            }
        }
    }
 
    private void startMatch(List<Combatant> team1, List<Combatant> team2, Scanner sc) {
        turnOrder.reset();
        List<Combatant> all = new ArrayList<>();
        all.addAll(team1);
        all.addAll(team2);
 
        while (isTeamAlive(team1) && isTeamAlive(team2)) {
            display.showBattlefield(team1, team2);
           
            for (Combatant current : all) {
                if (current.isAlive() && isTeamAlive(team1) && isTeamAlive(team2)) {
                    List<Combatant> allies = team1.contains(current) ? team1 : team2;
                    List<Combatant> enemies = team1.contains(current) ? team2 : team1;
                    if (current.takeTurnWithEscape(allies, enemies, sc) == 0) return;
                }
            }
            // Update cooldowns for everyone at the end of the round
            for (Combatant c : all) c.tickCooldowns();
            System.out.println("\n>>> Round complete. Cooldowns updated.");
        }
        System.out.println(isTeamAlive(team1) ? "TEAM 1 VICTORIOUS!" : "TEAM 2 VICTORIOUS!");
    }
 
    private boolean isTeamAlive(List<Combatant> team) {
        return team.stream().anyMatch(Combatant::isAlive);
    }
 
    private List<Combatant> createTeam(String prefix, int count, boolean isAi) {
        List<Combatant> team = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Combatant c = new Combatant(prefix + (count > 1 ? " " + i : ""), 100, 50, isAi);
            c.getSkills().add(new AttackSkill("Strike", 0, 10, 15, 0));
            c.getSkills().add(new AttackSkill("Heavy Smash", 15, 25, 35, 2));
            c.getSkills().add(new AttackSkill("Magic Bolt", 20, 30, 45, 3));
            c.getInventory().addItem(new Item("Heal Potion", 40, null));
            team.add(c);
        }
        return team;
    }
}