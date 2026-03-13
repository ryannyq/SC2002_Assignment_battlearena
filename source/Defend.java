import java.util.List;

/**
 * Defend action - increases defense by 10 for current round and next round.
 */
public class Defend implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        // Validate that source is not null
        // If validation fails, return early without executing
        
        // Create a new DefenseBoost with duration of 2 turns
        // Apply the defense boost effect to the source combatant
    }
}
