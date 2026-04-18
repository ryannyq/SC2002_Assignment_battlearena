// permanent ATK boost for the Wizard — stacks with each Arcane Blast kill
public class AttackBuff implements StatusEffect {
    private int duration;       // -1 = lasts until the level ends, never naturally expires
    private int attackIncrease;
    private static final String EFFECT_NAME = "AttackBuff";

    public AttackBuff(int attackIncrease) {
        this.attackIncrease = attackIncrease;
        this.duration = -1;
    }

    @Override
    public int getDuration() { return duration; }

    @Override
    public void decrementDuration() {
        // intentionally empty — this buff doesn't tick down
    }

    @Override
    public boolean isExpired() {
        return false;   // only removed when the level ends
    }

    @Override
    public void apply(Combatant combatant) {
        if (combatant != null) {
            combatant.setAttack(combatant.getAttack() + attackIncrease);
        }
    }

    @Override
    public void remove(Combatant combatant) {
        if (combatant != null) {
            combatant.setAttack(combatant.getAttack() - attackIncrease);
        }
    }

    @Override
    public String getName() { return EFFECT_NAME; }

    public int getAttackIncrease() { return attackIncrease; }
}
