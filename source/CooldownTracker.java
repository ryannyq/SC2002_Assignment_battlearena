// tracks when a special skill can be used again
// starts available (0), counts down from 3 after use, including the round it was used
public class CooldownTracker {
    private int turnsRemaining;
    private static final int COOLDOWN_DURATION = 3;

    public CooldownTracker() {
        this.turnsRemaining = 0;    // starts ready to use
    }

    public boolean isAvailable() {
        return turnsRemaining <= 0;
    }

    public void startCooldown() {
        this.turnsRemaining = COOLDOWN_DURATION;
    }

    public void decrementCooldown() {
        if (turnsRemaining > 0) turnsRemaining--;
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }

    public void reset() {
        this.turnsRemaining = 0;
    }
}
