import java.util.List;

/**
 * Basic attack action that deals damage based on attacker's ATK and target's DEF.
 * Formula: damage = max(0, attacker.ATK - target.DEF)
 * HP is clamped to 0 minimum.
 */
public class BasicAttack implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        // Validate that source and targets are not null and targets list is not empty
        // If validation fails, return early without executing
        
        // Get the attack stat of the source combatant
        
        // Iterate through each target in the targets list
            // Skip current iteration if target is null or already eliminated
            // Get the defense stat of the current target
            // Calculate damage as the difference between attacker's attack and target's defense
            // Ensure damage is non-negative (use max with 0)
            // Apply the calculated damage to the target
    }
}
