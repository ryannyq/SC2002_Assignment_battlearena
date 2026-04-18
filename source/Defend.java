import java.util.List;

public class Defend implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        // DefenseBoost handles the +10 DEF logic — Defend just applies it
        source.addStatusEffect(new DefenseBoost());
    }
}
