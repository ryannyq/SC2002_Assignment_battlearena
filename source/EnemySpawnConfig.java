import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for enemy spawning at a difficulty level.
 * Contains initial wave and backup wave enemy types.
 */
public class EnemySpawnConfig {
    private List<EnemyType> initialWave;
    private List<EnemyType> backupWave;
    
    public EnemySpawnConfig(List<EnemyType> initialWave, List<EnemyType> backupWave) {
        // Create defensive copies of the initial wave and backup wave lists
        // Store them in instance variables
    }
    
    public List<EnemyType> getInitialWave() {
        // Return a defensive copy of the initial wave list
    }
    
    public List<EnemyType> getBackupWave() {
        // Return a defensive copy of the backup wave list
    }
    
    /**
     * Enum for enemy types.
     */
    public enum EnemyType {
        GOBLIN,
        WOLF
    }
}
