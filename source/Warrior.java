import java.util.List;

/**
 * Warrior player class with high HP and defense.
 * Stats: HP: 260, ATK: 40, DEF: 20, SPD: 30
 */
public class Warrior extends Combatant {
    private static final int WARRIOR_HP = 260;
    private static final int WARRIOR_ATK = 40;
    private static final int WARRIOR_DEF = 20;
    private static final int WARRIOR_SPD = 30;
    
    public Warrior() {
        // Call parent constructor with name "Warrior" and predefined stats (HP, ATK, DEF, SPD)
    }
    
    @Override
    public Action getAction(List<Combatant> availableTargets) {
        // This will be implemented later when we have the action selection logic
        // For now, return null - the CLI will handle action selection
    }
}
