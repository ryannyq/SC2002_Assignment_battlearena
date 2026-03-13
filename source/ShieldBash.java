import java.util.List;

/**
 * Warrior's special skill - Shield Bash.
 * Deals BasicAttack damage and applies Stun effect to target.
 */
public class ShieldBash implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        // Validate that source and targets are not null and targets list is not empty
        // If validation fails, return early without executing
        
        // Get the first target from the targets list
        // Check if target is not null and is still alive
            // Get the attack stat of the source combatant
            // Get the defense stat of the target
            // Calculate damage as the difference between attacker's attack and target's defense
            // Ensure damage is non-negative (use max with 0)
            // Apply the calculated damage to the target
            
            // Check if target is still alive after taking damage
            // If target survived, create a new StunEffect with duration of 2 turns
            // Apply the stun effect to the target
    }
}
