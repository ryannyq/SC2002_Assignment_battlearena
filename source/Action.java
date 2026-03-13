import java.util.List;

/**
 * Interface defining the contract for all combat actions.
 * Follows Interface Segregation Principle - contains only what actions need.
 */
public interface Action {
    /**
     * Executes the action with the given source and targets.
     * 
     * @param source The combatant performing the action
     * @param targets The list of target combatants
     */
    void execute(Combatant source, List<Combatant> targets);
}
