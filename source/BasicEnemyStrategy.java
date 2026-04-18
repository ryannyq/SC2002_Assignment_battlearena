import java.util.List;

// enemies always use BasicAttack
public class BasicEnemyStrategy implements EnemyAction {
    @Override
    public Action getAction(Combatant enemy, List<Combatant> availableTargets) {
        if (enemy == null || availableTargets == null || availableTargets.isEmpty()) return null;

        // check there's actually someone alive to hit
        for (Combatant target : availableTargets) {
            if (target != null && target.isAlive()) return new BasicAttack();
        }

        return null;
    }
}
