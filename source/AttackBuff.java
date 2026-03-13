/**
 * Attack buff effect - permanently increases attack stat.
 * Used by Wizard's Arcane Blast - lasts until end of level.
 * This effect doesn't expire naturally (duration = -1 indicates permanent).
 */
public class AttackBuff implements StatusEffect {
    private int duration; // -1 indicates permanent
    private int attackIncrease;
    private static final String EFFECT_NAME = "AttackBuff";
    
    public AttackBuff(int attackIncrease) {
        // Store the attack increase amount
        // Set duration to -1 to indicate permanent effect (until level ends)
    }
    
    @Override
    public int getDuration() {
        // Return the current duration value (will be -1 for permanent effects)
    }
    
    @Override
    public void decrementDuration() {
        // Permanent effect - does not decrement (no operation needed)
    }
    
    @Override
    public boolean isExpired() {
        // Return false since this effect never expires naturally
    }
    
    @Override
    public void apply(Combatant combatant) {
        // Validate that combatant is not null
        // If valid, increase the combatant's attack stat by the attack increase amount
    }
    
    @Override
    public void remove(Combatant combatant) {
        // Validate that combatant is not null
        // If valid, decrease the combatant's attack stat by the attack increase amount
    }
    
    @Override
    public String getName() {
        // Return the predefined effect name constant
    }
    
    /**
     * Gets the attack increase amount.
     * 
     * @return The amount of attack increase
     */
    public int getAttackIncrease() {
        // Return the stored attack increase amount
    }
}
