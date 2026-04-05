import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Concrete implementation of TurnOrder that sorts by speed (descending).
 * Higher speed combatants act first.
 */
public class SpeedOrder implements TurnOrder {
    @Override
    public List<Combatant> sort(List<Combatant> combatants) {
        // Create a new list containing all combatants from the input list
        List<Combatant> sorted = new ArrayList<>(combatants);
        // Sort the list by speed in descending order (higher speed first)
        sorted.sort(Comparator.comparingInt(Combatant::getSpeed).reversed();
        // Return the sorted list
        return sorted;
    }
}
