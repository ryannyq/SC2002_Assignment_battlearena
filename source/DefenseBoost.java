/**
 * Defense boost status effect - increases defense by 10.
 * Duration: 2 turns (current round + next round).
 */
public class DefenseBoost implements StatusEffect {
    private int duration;
    private static final int BOOST_AMOUNT = 10;
    private static final String EFFECT_NAME = "DefenseBoost";
    private int originalDefense;
    
    public DefenseBoost() {
        // Initialize duration to 2 (current round + next round)
    }
    
    @Override
    public int getDuration() {
        // Return the current duration value
    }
    
    @Override
    public void decrementDuration() {
        // Check if duration is greater than 0
        // If so, decrement duration by 1
    }
    
    @Override
    public boolean isExpired() {
        // Return true if duration is less than or equal to 0, false otherwise
    }
    
    @Override
    public void apply(Combatant combatant) {
        // Validate that combatant is not null
        // If valid, store the combatant's current defense value as original defense
        // Note: Defense boost is applied dynamically in getDefense() method
    }
    
    @Override
    public void remove(Combatant combatant) {
        // Defense boost is removed when effect expires
        // The combatant's defense returns to original value
    }
    
    @Override
    public String getName() {
        // Return the predefined effect name constant
    }
    
    /**
     * Gets the defense boost amount.
     * 
     * @return The amount to add to defense
     */
    public int getBoostAmount() {
        // Return the predefined boost amount constant
    }
}
