/**
 * Utility class to track cooldowns for special skills.
 * Cooldown is 3 turns including the current turn.
 */
public class CooldownTracker {
    private int turnsRemaining;
    private static final int COOLDOWN_DURATION = 3;
    
    public CooldownTracker() {
        // Initialize turns remaining to 0 (skill is available)
    }
    
    /**
     * Checks if the skill is available (cooldown expired).
     * 
     * @return true if available, false if on cooldown
     */
    public boolean isAvailable() {
        // Return true if turns remaining is less than or equal to 0, false otherwise
    }
    
    /**
     * Starts the cooldown timer.
     */
    public void startCooldown() {
        // Set turns remaining to the predefined cooldown duration constant
    }
    
    /**
     * Decrements the cooldown by one turn.
     * Called at the end of each turn.
     */
    public void decrementCooldown() {
        // Check if turns remaining is greater than 0
        // If so, decrement turns remaining by 1
    }
    
    /**
     * Gets the remaining cooldown turns.
     * 
     * @return The number of turns remaining
     */
    public int getTurnsRemaining() {
        // Return the current turns remaining value
    }
    
    /**
     * Resets the cooldown (makes skill available immediately).
     */
    public void reset() {
        // Set turns remaining to 0
    }
}
