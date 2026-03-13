import java.util.List;

/**
 * Power Stone item - triggers special skill effect once for free without affecting cooldown.
 * Does not start or change the cooldown timer.
 */
public class PowerStone implements Item {
    private static final String ITEM_NAME = "Power Stone";
    
    @Override
    public void use(Combatant user, List<Combatant> targets) {
        // Validate that user is not null
        // If validation fails, return early without executing
        
        // Power Stone triggers the user's special skill
        // This will be handled by the game logic to determine which skill to use
        // The cooldown bypass is handled at a higher level (GameManager/CLI)
    }
    
    @Override
    public String getName() {
        // Return the predefined item name constant
    }
    
    @Override
    public boolean isConsumable() {
        // Return true since power stone is consumed upon use
    }
    
    /**
     * Executes the special skill for the user without affecting cooldown.
     * This method is called by the game logic to trigger the skill.
     * 
     * @param user The combatant using the power stone
     * @param skillAction The special skill action to execute
     * @param targets The targets for the skill
     */
    public void executeSkillWithoutCooldown(Combatant user, Action skillAction, List<Combatant> targets) {
        // Validate that user and skillAction are not null
        // If validation passes, execute the skill action with the given user and targets
        // Note: Cooldown is NOT started - this is handled by the caller
    }
}
