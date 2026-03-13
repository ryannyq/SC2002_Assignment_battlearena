import java.util.List;

/**
 * Strategy interface for determining turn order.
 * Follows Strategy Pattern and Open/Closed Principle - new sorting strategies can be added without modifying existing code.
 */
public interface TurnOrder {
    /**
     * Sorts the list of combatants based on the strategy's rules.
     * 
     * @param combatants The list of combatants to sort
     * @return A new sorted list (original list is not modified)
     */
    List<Combatant> sort(List<Combatant> combatants);
}
