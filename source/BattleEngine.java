import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// handles rounds, turns, and win/loss — knows nothing about the UI
public class BattleEngine {
    private List<Combatant> combatants;
    private List<Combatant> players;
    private List<Combatant> enemies;
    private TurnOrder turnOrderStrategy;
    private EnemyAction enemyActionStrategy;
    private List<BattleObserver> observers;
    private int currentRound;
    private GameState.BattleResult battleResult;

    public BattleEngine(TurnOrder turnOrderStrategy, EnemyAction enemyActionStrategy) {
        this.turnOrderStrategy   = turnOrderStrategy;
        this.enemyActionStrategy = enemyActionStrategy;
        this.combatants  = new ArrayList<>();
        this.players     = new ArrayList<>();
        this.enemies     = new ArrayList<>();
        this.observers   = new ArrayList<>();
        this.currentRound = 0;
        this.battleResult = GameState.BattleResult.ONGOING;
    }

    public void initialize(List<Combatant> players, List<Combatant> enemies) {
        this.players = new ArrayList<>(players);
        this.enemies = new ArrayList<>(enemies);
        this.combatants = new ArrayList<>();
        this.combatants.addAll(this.players);
        this.combatants.addAll(this.enemies);
        this.currentRound = 0;
        this.battleResult = GameState.BattleResult.ONGOING;
    }

    public void addObserver(BattleObserver observer) {
        if (observer != null) observers.add(observer);
    }

    public void removeObserver(BattleObserver observer) {
        observers.remove(observer);
    }

    // backup enemies joining mid-battle
    public void addEnemies(List<Combatant> newEnemies) {
        if (newEnemies != null && !newEnemies.isEmpty()) {
            enemies.addAll(newEnemies);
            combatants.addAll(newEnemies);
            battleResult = GameState.BattleResult.ONGOING;
        }
    }

    public GameState getGameState() {
        List<GameState.CombatantSnapshot> snapshots = combatants.stream()
                .map(GameState.CombatantSnapshot::new)
                .collect(Collectors.toList());
        return new GameState(snapshots, currentRound, battleResult);
    }

    public List<Combatant> getAlivePlayers() {
        return players.stream().filter(Combatant::isAlive).collect(Collectors.toList());
    }

    public List<Combatant> getAliveEnemies() {
        return enemies.stream().filter(Combatant::isAlive).collect(Collectors.toList());
    }

    public boolean isBattleOver() {
        return battleResult != GameState.BattleResult.ONGOING;
    }

    public GameState startRound() {
        if (isBattleOver()) return getGameState();

        currentRound++;

        // pull out dead combatants before effects tick
        combatants.removeIf(c -> !c.isAlive());

        // tick status effects once at the top of the round for everyone
        // stunned combatants get a second tick in checkStatusEffectExpiration (GameManager)
        // acting combatants do NOT get a second tick, executeTurn intentionally skips it
        for (Combatant c : combatants) {
            c.updateStatusEffects();
        }

        checkBattleEnd();

        GameState state = getGameState();
        notifyObservers(obs -> obs.onTurnStarted(state));
        return state;
    }

    public GameState executeTurn(Combatant combatant, Action action, List<Combatant> targets) {
        if (isBattleOver() || combatant == null || !combatant.canAct() || action == null) {
            return getGameState();
        }

        action.execute(combatant, targets);

        // effects are NOT ticked here on purpose — startRound() already handles the round-start tick
        // ticking here as well caused stun and DefenseBoost to expire a round too early

        // remove anyone who died this turn
        combatants.removeIf(c -> !c.isAlive());
        enemies.removeIf(c -> !c.isAlive());
        players.removeIf(c -> !c.isAlive());

        checkBattleEnd();

        GameState state = getGameState();
        notifyObservers(obs -> obs.onActionResolved(state));
        return state;
    }

    public List<Combatant> getTurnOrder() {
        List<Combatant> alive = combatants.stream()
                .filter(Combatant::isAlive)
                .collect(Collectors.toList());
        return turnOrderStrategy.sort(alive);
    }

    public Action getEnemyAction(Combatant enemy) {
        if (enemy != null && enemies.contains(enemy)) {
            return enemyActionStrategy.getAction(enemy, getAlivePlayers());
        }
        return null;
    }

    private void checkBattleEnd() {
        if (getAlivePlayers().isEmpty()) {
            battleResult = GameState.BattleResult.DEFEAT;
            GameState state = getGameState();
            notifyObservers(obs -> obs.onBattleEnded(state));
        } else if (getAliveEnemies().isEmpty()) {
            battleResult = GameState.BattleResult.VICTORY;
            GameState state = getGameState();
            notifyObservers(obs -> obs.onBattleEnded(state));
        }
    }

    private void notifyObservers(java.util.function.Consumer<BattleObserver> notification) {
        for (BattleObserver obs : observers) {
            notification.accept(obs);
        }
    }
}
