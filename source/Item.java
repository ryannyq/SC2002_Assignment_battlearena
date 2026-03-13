/**
 * Interface for consumable items that can be used during combat.
 * Follows Interface Segregation Principle - items only implement what they need.
 */
public interface Item {
    /**
     * Uses the item, applying its effect to the target combatant.
     * 
     * @param user The combatant using the item
     * @param targets The list of target combatants (may be empty for self-targeting items)
     */
    void use(Combatant user, java.util.List<Combatant> targets);
    
    /**
     * Gets the name of this item.
     * 
     * @return The name of the item
     */
    String getName();
    
    /**
     * Checks if this item is consumed upon use.
     * 
     * @return true if the item is consumed, false otherwise
     */
    boolean isConsumable();
}
