import java.util.List;

public class ArcaneBlast implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        if (source == null || targets == null || targets.isEmpty()) return;

        // hit each enemy one by one — ATK goes up with each kill so subsequent targets take more damage
        for (Combatant target : targets) {
            if (target == null || !target.isAlive()) continue;

            int damage = Math.max(0, source.getAttack() - target.getDefense());
            boolean wasAlive = target.isAlive();

            target.takeDamage(damage);

            // +10 ATK immediately per kill so the next target in this loop gets hit harder
            if (wasAlive && !target.isAlive()) {
                source.addStatusEffect(new AttackBuff(10));
            }
        }
    }
}
