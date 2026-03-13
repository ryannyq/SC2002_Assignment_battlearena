import java.util.ArrayList;
import java.util.List;

/**
 * Basic enemy AI strategy - enemies always use BasicAttack on the first available target.
 */
public class BasicEnemyStrategy implements EnemyAction {
    @Override
    public Action getAction(Combatant enemy, List<Combatant> availableTargets) {
        // Validate that enemy and availableTargets are not null and targets list is not empty
        // If validation fails, return null
        
        // Create a new list to store selected targets
        // Iterate through available targets to find the first alive target
            // Check if target is not null and is still alive
            // If found, add target to the list and break out of loop (basic strategy: attack first available target)
        
        // Check if no valid targets were found
        // If no targets found, return null
        
        // Return a new BasicAttack action
    }
}
