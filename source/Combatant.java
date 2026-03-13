import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all combatants (players and enemies).
 * Follows Dependency Inversion Principle - depends on abstractions (Action, StatusEffect).
 * Follows Single Responsibility Principle - manages combatant state only.
 */
public abstract class Combatant {
    protected int maxHP;
    protected int currentHP;
    protected int attack;
    protected int defense;
    protected int speed;
    protected String name;
    protected List<StatusEffect> activeEffects;
    
    /**
     * Constructor for Combatant.
     * 
     * @param name The name of the combatant
     * @param maxHP Maximum health points
     * @param attack Attack stat
     * @param defense Defense stat
     * @param speed Speed stat (determines turn order)
     */
    public Combatant(String name, int maxHP, int attack, int defense, int speed) {
        // Initialize all instance variables with the provided parameters
        // Set currentHP to maxHP (full health at start)
        // Initialize activeEffects as a new empty list
    }
    
    // Getters
    public int getMaxHP() {
        // Return the maximum HP value
    }
    
    public int getCurrentHP() {
        // Return the current HP value
    }
    
    public int getAttack() {
        // Return the attack stat value
    }
    
    public int getDefense() {
        // Start with base defense value
        // Iterate through all active status effects
            // Check if effect is an instance of DefenseBoost
            // If so, add the boost amount to base defense
        // Return the calculated defense value
    }
    
    public int getSpeed() {
        // Return the speed stat value
    }
    
    public String getName() {
        // Return the name of the combatant
    }
    
    public List<StatusEffect> getActiveEffects() {
        // Return a defensive copy of the active effects list to prevent external modification
    }
    
    // Setters (protected to allow subclasses to modify)
    protected void setCurrentHP(int hp) {
        // Clamp HP value between 0 and maxHP (use Math.max and Math.min)
        // Set currentHP to the clamped value
    }
    
    protected void setAttack(int attack) {
        // Set the attack stat to the provided value
    }
    
    protected void setDefense(int defense) {
        // Set the defense stat to the provided value
    }
    
    /**
     * Reduces HP by the specified amount.
     * HP is clamped to 0 minimum.
     * Checks for DamageZeroEffect - if present, damage is reduced to 0.
     * 
     * @param damage The amount of damage to take
     */
    public void takeDamage(int damage) {
        // Check if combatant has the "DamageNullifier" status effect
        // If present, set damage to 0
        // Calculate new HP by subtracting damage from currentHP
        // Clamp the result to ensure it's not less than 0 (use Math.max with 0)
        // Set currentHP to the clamped value
    }
    
    /**
     * Heals HP by the specified amount.
     * HP is clamped to maxHP maximum.
     * 
     * @param amount The amount of HP to restore
     */
    public void heal(int amount) {
        // Calculate new HP by adding amount to currentHP
        // Clamp the result to ensure it's not greater than maxHP (use Math.min with maxHP)
        // Set currentHP to the clamped value
    }
    
    /**
     * Checks if the combatant is alive.
     * 
     * @return true if currentHP > 0, false otherwise
     */
    public boolean isAlive() {
        // Return true if currentHP is greater than 0, false otherwise
    }
    
    /**
     * Adds a status effect to this combatant.
     * 
     * @param effect The status effect to add
     */
    public void addStatusEffect(StatusEffect effect) {
        // Validate that effect is not null and is not already in the active effects list
        // If valid, add effect to activeEffects list
        // Call the effect's apply method with this combatant as parameter
    }
    
    /**
     * Removes a status effect from this combatant.
     * 
     * @param effect The status effect to remove
     */
    public void removeStatusEffect(StatusEffect effect) {
        // Validate that effect is not null and is in the active effects list
        // If valid, remove effect from activeEffects list
        // Call the effect's remove method with this combatant as parameter
    }
    
    /**
     * Checks if this combatant has a specific status effect.
     * 
     * @param effectName The name of the effect to check for
     * @return true if the effect is active, false otherwise
     */
    public boolean hasStatusEffect(String effectName) {
        // Use stream to check if any active effect's name matches the given effect name
        // Return true if match found, false otherwise
    }
    
    /**
     * Updates all status effects, decrementing their duration.
     * Removes expired effects.
     */
    public void updateStatusEffects() {
        // Create a list to store expired effects
        // Iterate through all active effects
            // Decrement each effect's duration
            // Check if effect is expired
            // If expired, add to expired effects list
        // Iterate through expired effects list
            // Remove each expired effect using removeStatusEffect method
    }
    
    /**
     * Gets the action this combatant wants to perform.
     * This method will be overridden by subclasses to provide different behaviors.
     * 
     * @param availableTargets List of available target combatants
     * @return The action to execute, or null if no action can be taken
     */
    public abstract Action getAction(List<Combatant> availableTargets);
    
    /**
     * Checks if this combatant can take actions (not stunned, etc.).
     * 
     * @return true if the combatant can act, false otherwise
     */
    public boolean canAct() {
        // Return true if combatant is alive AND does not have "Stun" status effect
    }
}
