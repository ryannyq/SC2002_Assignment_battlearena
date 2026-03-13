import java.util.List;

/**
 * Wolf enemy class with high attack and speed but low defense.
 * Stats: HP: 40, ATK: 45, DEF: 5, SPD: 35
 */
public class Wolf extends Combatant {
    private static final int WOLF_HP = 40;
    private static final int WOLF_ATK = 45;
    private static final int WOLF_DEF = 5;
    private static final int WOLF_SPD = 35;
    
    public Wolf() {
        // Call parent constructor with name "Wolf" and predefined stats (HP, ATK, DEF, SPD)
    }
    
    @Override
    public Action getAction(List<Combatant> availableTargets) {
        // Enemy AI will be implemented later
        // For now, return null - the enemy action strategy will handle this
    }
}
