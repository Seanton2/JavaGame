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