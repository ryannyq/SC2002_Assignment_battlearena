import java.util.List;

public class BasicAttack implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        if (source == null || targets == null || targets.isEmpty()) return;

        int atk = source.getAttack();

        for (Combatant target : targets) {
            if (target == null || !target.isAlive()) continue;

            // spec formula: max(0, ATK - DEF)
            int damage = Math.max(0, atk - target.getDefense());
            target.takeDamage(damage);
        }
    }
}