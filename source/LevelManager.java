import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages difficulty levels and enemy spawning configurations.
 * Maps difficulty levels to enemy spawn configurations.
 */
public class LevelManager {
    private Map<Difficulty, EnemySpawnConfig> difficultyConfigs;
    
    public LevelManager() {
        // Initialize the difficulty configurations map
        // Call method to set up all difficulty level configurations

        difficultyConfigs = new HashMap<>();

        initializeConfigurations();
    }
    
    /**
     * Initializes the difficulty configurations according to PRD:
     * - Easy: Initial: 3 Goblins, Backup: None
     * - Medium: Initial: 1 Goblin + 1 Wolf, Backup: 2 Wolves
     * - Hard: Initial: 2 Goblins, Backup: 1 Goblin + 2 Wolves
     */
    private void initializeConfigurations() {
        // For Easy difficulty:
        // Create a list for initial wave and add 3 GOBLIN enemy types
        // Create an empty list for backup wave
        // Create an EnemySpawnConfig with these lists and store it in the map with EASY key
        
        // For Medium difficulty:
        // Create a list for initial wave and add 1 GOBLIN and 1 WOLF enemy types
        // Create a list for backup wave and add 2 WOLF enemy types
        // Create an EnemySpawnConfig with these lists and store it in the map with MEDIUM key
        
        // For Hard difficulty:
        // Create a list for initial wave and add 2 GOBLIN enemy types
        // Create a list for backup wave and add 1 GOBLIN and 2 WOLF enemy types
        // Create an EnemySpawnConfig with these lists and store it in the map with HARD key


        List<EnemySpawnConfig.EnemyType> easy_diff = new ArrayList<>();
        easy_diff.add(EnemySpawnConfig.EnemyType.GOBLIN);
        easy_diff.add(EnemySpawnConfig.EnemyType.GOBLIN);
        easy_diff.add(EnemySpawnConfig.EnemyType.GOBLIN);

        List<EnemySpawnConfig.EnemyType> easy_backup = new ArrayList<>();

        difficultyConfigs.put(Difficulty.EASY, new EnemySpawnConfig(easy_diff, easy_backup));

        List<EnemySpawnConfig.EnemyType> medium_diff = new ArrayList<>();
        medium_diff.add(EnemySpawnConfig.EnemyType.GOBLIN);
        medium_diff.add(EnemySpawnConfig.EnemyType.WOLF);

        List<EnemySpawnConfig.EnemyType> medium_backup = new ArrayList<>();
        medium_backup.add(EnemySpawnConfig.EnemyType.WOLF);
        medium_backup.add(EnemySpawnConfig.EnemyType.WOLF);

        difficultyConfigs.put(Difficulty.MEDIUM, new EnemySpawnConfig(medium_diff, medium_backup));

        List<EnemySpawnConfig.EnemyType> hard_diff = new ArrayList<>();
        hard_diff.add(EnemySpawnConfig.EnemyType.GOBLIN);
        hard_diff.add(EnemySpawnConfig.EnemyType.GOBLIN);

        List<EnemySpawnConfig.EnemyType> hard_Backup = new ArrayList<>();
        hard_Backup.add(EnemySpawnConfig.EnemyType.GOBLIN);
        hard_Backup.add(EnemySpawnConfig.EnemyType.WOLF);
        hard_Backup.add(EnemySpawnConfig.EnemyType.WOLF);

        difficultyConfigs.put(Difficulty.HARD, new EnemySpawnConfig(hard_diff, hard_Backup));




    }
    
    /**
     * Gets the spawn configuration for a difficulty level.
     * 
     * @param difficulty The difficulty level
     * @return The enemy spawn configuration
     */
    public EnemySpawnConfig getSpawnConfig(Difficulty difficulty) {
        // Retrieve and return the spawn configuration for the given difficulty level from the map
        return difficultyConfigs.get(difficulty);
    }
    
    /**
     * Creates enemy combatants from a list of enemy types.
     * 
     * @param enemyTypes List of enemy types to create
     * @return List of created enemy combatants
     */
    public List<Combatant> createEnemies(List<EnemySpawnConfig.EnemyType> enemyTypes) {
        // Create a new list to store enemy combatants
        // Iterate through each enemy type in the input list
            // Use a switch statement to determine which enemy class to instantiate
            // For GOBLIN type, create a new Goblin instance and add to list
            // For WOLF type, create a new Wolf instance and add to list
        // Return the list of created enemies

        List<Combatant> enemies = new ArrayList<>();

        for (EnemySpawnConfig.EnemyType type : enemyTypes) {

            switch (type) {
                case GOBLIN:
                    enemies.add(new Goblin());
                    break;

                case WOLF:
                    enemies.add(new Wolf());
                    break;
            }
        }

      return enemies;
    }
    
    /**
     * Gets the initial wave of enemies for a difficulty level.
     * 
     * @param difficulty The difficulty level
     * @return List of initial enemy combatants
     */
    public List<Combatant> getInitialWave(Difficulty difficulty) {
        // Get the spawn configuration for the given difficulty level
        // If configuration is null, return an empty list
        // Otherwise, create enemies from the initial wave enemy types and return the list

        EnemySpawnConfig config = getSpawnConfig(difficulty);

        if (config == null) {
            return new ArrayList<>();
        }

        return createEnemies(config.getInitialWave());



    }
    
    /**
     * Gets the backup wave of enemies for a difficulty level.
     * 
     * @param difficulty The difficulty level
     * @return List of backup enemy combatants
     */
    public List<Combatant> getBackupWave(Difficulty difficulty) {
        // Get the spawn configuration for the given difficulty level
        // If configuration is null, return an empty list
        // Otherwise, create enemies from the backup wave enemy types and return the list
        EnemySpawnConfig config = getSpawnConfig(difficulty);


        if (config == null) {
            return new ArrayList<>();
        }

        return createEnemies(config.getBackupWave());

    }
}
