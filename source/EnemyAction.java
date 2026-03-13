import java.util.List;

/**
 * Strategy interface for enemy AI behavior.
 * Follows Strategy Pattern - allows different AI behaviors without modifying BattleEngine (OCP).
 */
public interface EnemyAction {
    /**
     * Determines the action an enemy should take.
     * 
     * @param enemy The enemy combatant
     * @param availableTargets List of available target combatants
     * @return The action to execute
     */
    Action getAction(Combatant enemy, List<Combatant> availableTargets);
}
