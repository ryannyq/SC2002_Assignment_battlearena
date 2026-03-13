/**
 * Interface for status effects that modify combatant behavior or stats.
 * Follows Interface Segregation Principle - effects only implement what they need.
 */
public interface StatusEffect {
    /**
     * Gets the remaining duration of this effect in turns.
     * 
     * @return The number of turns remaining
     */
    int getDuration();
    
    /**
     * Decrements the duration by one turn.
     * Called at the end of each turn.
     */
    void decrementDuration();
    
    /**
     * Checks if this effect has expired (duration <= 0).
     * 
     * @return true if the effect has expired, false otherwise
     */
    boolean isExpired();
    
    /**
     * Applies the effect to the combatant.
     * Called when the effect is first applied.
     * 
     * @param combatant The combatant to apply the effect to
     */
    void apply(Combatant combatant);
    
    /**
     * Removes the effect from the combatant.
     * Called when the effect expires or is removed.
     * 
     * @param combatant The combatant to remove the effect from
     */
    void remove(Combatant combatant);
    
    /**
     * Gets the name of this status effect.
     * 
     * @return The name of the effect
     */
    String getName();
}
