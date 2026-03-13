/**
 * Interface for observing battle events.
 * Follows Observer Pattern to decouple UI from engine (SRP).
 */
public interface BattleObserver {
    /**
     * Called when a turn starts.
     * 
     * @param state The current game state
     */
    void onTurnStarted(GameState state);
    
    /**
     * Called when an action is resolved.
     * 
     * @param state The updated game state after the action
     */
    void onActionResolved(GameState state);
    
    /**
     * Called when the battle ends.
     * 
     * @param state The final game state
     */
    void onBattleEnded(GameState state);
}
