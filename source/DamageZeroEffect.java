// applied by Smoke Bomb,makes the player immune to all damage for 2 turns
// Combatant.takeDamage() checks for this by name, so the name constant must match exactly
public class DamageZeroEffect implements StatusEffect {
    private int duration;

    private static final String EFFECT_NAME = "DamageZeroEffect";

    public DamageZeroEffect() {
        // current turn + next turn
        this.duration = 2;
    }

    @Override
    public int getDuration() { return duration; }

    @Override
    public void decrementDuration() {

        if (duration > 0) duration--;
    }

    @Override
    public boolean isExpired() { return duration <= 0; }

    @Override
    public void apply(Combatant combatant) {
        // passive Combatant.takeDamage() handles the actual immunity check
    }

    @Override
    public void remove(Combatant combatant) {

    }

    @Override
    public String getName() { return EFFECT_NAME; }
}
