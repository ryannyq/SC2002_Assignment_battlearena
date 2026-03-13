/**
 * Damage nullifier effect - prevents all incoming damage.
 * Duration: 2 turns (current turn + next turn).
 * Used by Smoke Bomb item.
 */
public class DamageZeroEffect implements StatusEffect {
    private int duration;
    private static final String EFFECT_NAME = "DamageNullifier";
    
    public DamageZeroEffect() {
        // Initialize duration to 2 (current turn + next turn)
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
        // Effect is passive - damage calculation will check for this
    }
    
    @Override
    public void remove(Combatant combatant) {
        // No cleanup needed
    }
    
    @Override
    public String getName() {
        // Return the predefined effect name constant
    }
}
