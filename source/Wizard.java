import java.util.List;

/**
 * Wizard player class with high attack but low defense.
 * Stats: HP: 200, ATK: 50, DEF: 10, SPD: 20
 */
public class Wizard extends Combatant {
    private static final int WIZARD_HP = 200;
    private static final int WIZARD_ATK = 50;
    private static final int WIZARD_DEF = 10;
    private static final int WIZARD_SPD = 20;
    
    public Wizard() {
        // Call parent constructor with name "Wizard" and predefined stats (HP, ATK, DEF, SPD)
    }
    
    @Override
    public Action getAction(List<Combatant> availableTargets) {
        // This will be implemented later when we have the action selection logic
        // For now, return null - the CLI will handle action selection
    }
}
