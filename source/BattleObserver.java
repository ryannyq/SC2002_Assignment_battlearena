// observer pattern,lets the UI react to battle events without BattleEngine knowing about it
public interface BattleObserver {
    void onTurnStarted(GameState state);
    void onActionResolved(GameState state);
    void onBattleEnded(GameState state);
}
