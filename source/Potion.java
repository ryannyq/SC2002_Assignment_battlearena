import java.util.List;

/**
 * Potion item - heals 100 HP.
 * Formula: min(Current HP + 100, Max HP)
 */
public class Potion implements Item {
    private static final int HEAL_AMOUNT = 100;
    private static final String ITEM_NAME = "Potion";
    
    @Override
    public void use(Combatant user, List<Combatant> targets) {
        // Validate that user is not null
        // If validation fails, return early without executing
        
        // Heal the user by the predefined heal amount (HP is clamped to maxHP maximum)
    }
    
    @Override
    public String getName() {
        // Return the predefined item name constant
    }
    
    @Override
    public boolean isConsumable() {
        // Return true since potion is consumed upon use
    }
}
