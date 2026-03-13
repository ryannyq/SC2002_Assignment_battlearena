import java.util.List;

/**
 * Goblin enemy class with balanced stats.
 * Stats: HP: 55, ATK: 35, DEF: 15, SPD: 25
 */
public class Goblin extends Combatant {
    private static final int GOBLIN_HP = 55;
    private static final int GOBLIN_ATK = 35;
    private static final int GOBLIN_DEF = 15;
    private static final int GOBLIN_SPD = 25;
    
    public Goblin() {
        // Call parent constructor with name "Goblin" and predefined stats (HP, ATK, DEF, SPD)
    }
    
    @Override
    public Action getAction(List<Combatant> availableTargets) {
        // Enemy AI will be implemented later
        // For now, return null - the enemy action strategy will handle this
    }
}
