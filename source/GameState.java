import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object representing the current state of the battle.
 * Immutable to ensure UI separation from engine logic (SRP).
 */
public class GameState {
    private final List<CombatantSnapshot> combatants;
    private final int currentRound;
    private final BattleResult result;
    
    public GameState(List<CombatantSnapshot> combatants, int currentRound, BattleResult result) {
        // Create a defensive copy of the combatants list
        // Store the current round and battle result
    }
    
    public List<CombatantSnapshot> getCombatants() {
        // Return a defensive copy of the combatants list
    }
    
    public int getCurrentRound() {
        // Return the current round number
    }
    
    public BattleResult getResult() {
        // Return the battle result
    }
    
    /**
     * Snapshot of a combatant's state at a point in time.
     */
    public static class CombatantSnapshot {
        private final String name;
        private final int currentHP;
        private final int maxHP;
        private final int attack;
        private final int defense;
        private final int speed;
        private final List<String> activeEffects;
        private final boolean isAlive;
        
        public CombatantSnapshot(Combatant combatant) {
            // Copy all combatant properties: name, currentHP, maxHP, attack, defense, speed, isAlive
            // Initialize activeEffects as a new empty list
            // Iterate through combatant's active effects
                // Add each effect's name to the activeEffects list
        }
        
        public String getName() {
            // Return the name
        }
        
        public int getCurrentHP() {
            // Return the current HP
        }
        
        public int getMaxHP() {
            // Return the max HP
        }
        
        public int getAttack() {
            // Return the attack stat
        }
        
        public int getDefense() {
            // Return the defense stat
        }
        
        public int getSpeed() {
            // Return the speed stat
        }
        
        public List<String> getActiveEffects() {
            // Return a defensive copy of the active effects list
        }
        
        public boolean isAlive() {
            // Return the isAlive status
        }
    }
    
    /**
     * Enum representing the result of the battle.
     */
    public enum BattleResult {
        ONGOING,
        VICTORY,
        DEFEAT
    }
}
