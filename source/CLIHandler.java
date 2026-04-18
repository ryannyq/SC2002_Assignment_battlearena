import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// sole class responsible for all console I/O, no game logic lives here
public class CLIHandler {
    private Scanner scanner;
    private Map<Combatant, String> enemyLabels;  // A, B, C labels so players can tell enemies apart

    public CLIHandler() {
        this.scanner     = new Scanner(System.in);
        this.enemyLabels = new HashMap<>();
    }

    // called at the start of each game to assign letters to the initial enemy wave
    public void initializeEnemyLabels(List<Combatant> enemies) {
        enemyLabels.clear();
        char label = 'A';
        for (Combatant enemy : enemies) {
            enemyLabels.put(enemy, String.valueOf(label));
            label++;
        }
    }

    // called when backup enemies arrive ,skips letters already taken so labels stay unique
    public void addEnemyLabels(List<Combatant> newEnemies) {
        char label = 'A';
        for (Combatant enemy : newEnemies) {
            if (!enemyLabels.containsKey(enemy)) {
                while (enemyLabels.containsValue(String.valueOf(label))) {
                    label++;
                }
                enemyLabels.put(enemy, String.valueOf(label));
            }
        }
    }

    public String getEnemyLabel(Combatant enemy) {
        return enemyLabels.getOrDefault(enemy, enemy.getName());
    }

    public void displayLoadingScreen() {
        System.out.println("____________________");
        System.out.println("    Battle Arena    ");
        System.out.println("____________________");
        System.out.println();
        System.out.println(" Available Players: ");
        System.out.println();
        System.out.println("        Warrior                     Wizard");
        System.out.println();
        System.out.println("           ^                          .");
        System.out.println("           |                          |");
        System.out.println("         ==+==                        |");
        System.out.println("           |                          |");
        System.out.println("         sword                      wand");
        System.out.println();
        System.out.println(" 1. Warrior - High HP/DEF, Special: Shield Bash (stuns enemy) ");
        System.out.println(" 2. Wizard - High ATK, Special: Arcane Blast (hits all enemies, +10 ATK per kill) ");
        System.out.println();
        System.out.println(" Difficulty Levels: ");
        System.out.println(" 1. Easy ");
        System.out.println(" 2. Medium ");
        System.out.println(" 3. Hard ");
        System.out.println();
        System.out.println("Enemy Types:");
        System.out.println();
        System.out.println(" Goblin - Low HP/DEF, fast");
        System.out.println();
        System.out.println("             ,      ,");
        System.out.println("            /(.-\"\"-.)\\");
        System.out.println("        |\\  \\/      \\/  /|");
        System.out.println("        | \\ / =.  .= \\ / |");
        System.out.println("        \\( \\   o\\/o   / )/");
        System.out.println("         \\_, '-/  \\-' ,_/");
        System.out.println("           /   \\__/   \\");
        System.out.println("           \\ \\__/\\__/ /");
        System.out.println("         ___\\ \\|--|/ /___");
        System.out.println("       /`    \\      /    `\\");
        System.out.println("     /       '----'       \\");
        System.out.println();
        System.out.println(" Wolf - Higher ATK/SPD, more aggressive");
        System.out.println();
        System.out.println("                     .");
        System.out.println("                    / V\\");
        System.out.println("                  / `  /");
        System.out.println("                 <<   |");
        System.out.println("                 /    |");
        System.out.println("               /      |");
        System.out.println("             /        |");
        System.out.println("           /    \\  \\ /");
        System.out.println("          (      ) | |");
        System.out.println("  ________|   _/_  | |");
        System.out.println("<__________\\______)\\__)");
        System.out.println();
    }

    public Combatant selectPlayer() {
        System.out.println("Select a player (1 or 2):");
        System.out.println();
        System.out.println(" 1. Warrior");
        System.out.println(" 2. Wizard");
        System.out.println();
        int choice = readInt(1, 2);

        switch (choice) {
            case 1: return new Warrior();
            case 2: return new Wizard();
            default: return null;
        }
    }

    // player picks 2 items at the start — duplicates are allowed per the spec
    public List<Item> selectItems() {
        System.out.println("Pick 2 items (duplicates allowed):");
        System.out.println();
        System.out.println(" 1. Potion      - restore 100 HP");
        System.out.println(" 2. Smoke Bomb  - enemy attacks deal 0 damage for 2 turns");
        System.out.println(" 3. Power Stone - trigger your special skill for free once");
        System.out.println();

        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            System.out.println("Pick item " + i + ":");
            int choice = readInt(1, 3);
            switch (choice) {
                case 1: items.add(new Potion());     break;
                case 2: items.add(new SmokeBomb());  break;
                case 3: items.add(new PowerStone()); break;
            }
            System.out.println();
        }
        return items;
    }
    // player picks difficulty
    public Difficulty selectDifficulty() {
        System.out.println("Select difficulty (1-3):");
        System.out.println();
        System.out.println(" 1. Easy");
        System.out.println(" 2. Medium");
        System.out.println(" 3. Hard");
        System.out.println();
        int choice = readInt(1, 3);

        switch (choice) {
            case 1: return Difficulty.EASY;
            case 2: return Difficulty.MEDIUM;
            case 3: return Difficulty.HARD;
            default: return Difficulty.EASY;
        }
    }

    public void displayRoundHeader(int round) {
        System.out.println();
        System.out.println("Round " + round);
        System.out.println();
    }


    public void displayAction(String actor, String actionName, String target,
                              int hpBefore, int hpAfter, int attackerATK, int targetDEF, int damage) {
        String calc = attackerATK + "-" + targetDEF + "=" + damage;

        if (hpAfter <= 0) {
            System.out.println(actor + " -> " + actionName + " -> " + target
                    + ": HP: " + hpBefore + " -> 0 X ELIMINATED (dmg: " + calc + ")");
        } else {
            System.out.println(actor + " -> " + actionName + " -> " + target
                    + ": HP: " + hpBefore + " -> " + hpAfter + " (dmg: " + calc + ")");
        }
        System.out.println();
    }


    public void displayCooldownSet(int cooldownRounds) {
        System.out.println("Cooldown set to " + cooldownRounds + " rounds");
    }

    public void displayCooldownUnchanged(int cooldownRounds) {
        System.out.println("Cooldown unchanged (Power Stone does not affect cooldown) -> " + cooldownRounds + " rounds");
    }


    public void displayNullifiedBasicAttack(String actor, String target, String targetDisplay, int targetHP) {
        System.out.println(actor + " -> BasicAttack -> " + target
                + ": 0 damage (Smoke Bomb active) | " + targetDisplay + " HP: " + targetHP);
    }

    public void displayStatusEffect(String target, String effect, int duration) {
        System.out.println(target + " STUNNED (" + duration + " turns)");
    }

    public void displayStunExpires() {
        System.out.println("Stun expires");
    }

    public void displaySmokeBombExpires() {
        System.out.println("Smoke Bomb effect expires");
    }

    public void displaySkippedTurn(String combatant, String reason) {
        if (reason.equals("STUNNED")) {
            System.out.println(combatant + " -> STUNNED: Turn skipped");
        } else if (reason.equals("ELIMINATED")) {
            System.out.println(combatant + " -> ELIMINATED: Skipped");
        }
    }

    public void displayItemUsage(String actor, String itemName, String effect) {
        System.out.println(actor + " -> Item -> " + itemName + " used: " + effect);
    }

    public void displayEndOfRound(int round, List<Combatant> combatants, Map<Combatant, String> enemyLabels,
                                  int potionCount, int smokeBombCount, int powerStoneCount,
                                  int cooldownRounds, boolean hasItems, Combatant player) {
        List<String> parts = new ArrayList<>();

        // player HP first
        for (Combatant c : combatants) {
            if (c instanceof Warrior || c instanceof Wizard) {
                String status = c.isAlive()
                        ? c.getName() + " HP: " + c.getCurrentHP() + "/" + c.getMaxHP()
                        : c.getName() + " HP: " + c.getCurrentHP();
                parts.add(status);
            }
        }

        // enemies sorted alphabetically by their label
        List<Combatant> enemyList = new ArrayList<>();
        for (Combatant c : combatants) {
            if (c instanceof Goblin || c instanceof Wolf) enemyList.add(c);
        }
        enemyList.sort((a, b) -> {
            String la = enemyLabels.getOrDefault(a, "");
            String lb = enemyLabels.getOrDefault(b, "");
            return la.compareTo(lb);
        });

        for (Combatant e : enemyList) {
            String type      = e.getClass().getSimpleName();
            String label     = enemyLabels.getOrDefault(e, "");
            String fullLabel = label.isEmpty() ? type : type + " " + label;

            if (!e.isAlive()) {
                parts.add(fullLabel + " HP: " + e.getCurrentHP());
            } else {
                String status = fullLabel + " HP: " + e.getCurrentHP() + "/" + e.getMaxHP();

                if (e.hasStatusEffect("Stun")) status += " [STUNNED]";
                parts.add(status);
            }
        }


        if (player instanceof Warrior) {
            parts.add((potionCount == 0)    ? "Potion: 0 <- consumed"    : "Potion: " + potionCount);
            parts.add((smokeBombCount == 0) ? "Smoke Bomb: 0 <- consumed" : "Smoke Bomb: " + smokeBombCount);
            if (!hasItems && potionCount == 0 && smokeBombCount == 0) {
                parts.add("Item action no longer available");
            }
        } else if (player instanceof Wizard) {
            parts.add((powerStoneCount == 0) ? "Power Stone: 0 <- consumed" : "Power Stone: " + powerStoneCount);
            parts.add((potionCount == 0)     ? "Potion: 0 <- consumed"      : "Potion: " + potionCount);
            if (!hasItems && powerStoneCount == 0 && potionCount == 0) {
                parts.add("Item action no longer available");
            }
            // only show ATK if it's been boosted above base
            if (player.getAttack() > 50) {
                parts.add("Wizard ATK: " + player.getAttack());
            }
        }


        String cooldownText;
        if (cooldownRounds == 0)      cooldownText = "Special Skills Cooldown: 0 Round";
        else if (cooldownRounds == 1) cooldownText = "Special Skills Cooldown: 1 round";
        else                          cooldownText = "Special Skills Cooldown: " + cooldownRounds + " rounds";
        parts.add(cooldownText);

        System.out.println();
        System.out.println("End of Round " + round + ": " + String.join(" | ", parts));
        System.out.println();
    }

    public void displayArcaneBlastSummary(String actor, String actionName, List<String> enemyResults,
                                          int initialATK, int kills, boolean goblinSurvives,
                                          Integer cooldownRounds) {
        System.out.print(actor + " -> Arcane Blast -> All Enemies: ");
        System.out.print(String.join(" | ", enemyResults));

        if (kills > 0) {
            int finalATK = initialATK + (kills * 10);
            System.out.print(" | ATK: " + initialATK + " -> " + finalATK + " (+" + (kills * 10) + " per Arcane Blast kill)");
        }
        if (goblinSurvives) System.out.print(" | Goblin survives");

        System.out.println();
        if (cooldownRounds != null) displayCooldownSet(cooldownRounds);
        System.out.println();
    }

    public void displayPowerStoneTriggered(String actor, String skillName) {
        System.out.println(actor + " -> Item -> Power Stone used -> " + skillName + " triggered");
    }

    public void displayArcaneBlastPowerStone(String actor, int attackerATK, List<String> enemyResults,
                                             int kills, boolean allDefeated) {
        System.out.print("-> All Enemies (ATK: " + attackerATK + "): ");
        System.out.print(String.join(" | ", enemyResults));

        if (kills > 0) {
            int finalATK = attackerATK + (kills * 10);
            System.out.print(" | ATK: " + attackerATK + " -> " + finalATK);
        }
        if (allDefeated) System.out.print(" | All enemies defeated");
        System.out.println();
    }

    public void displayPowerStoneConsumedAndCooldownUnchanged(int cooldownRounds) {
        System.out.println("Power Stone consumed | Cooldown unchanged -> " + cooldownRounds + " rounds left");
    }

    public void displayNewline() {
        System.out.println();
    }

    public int selectAction(boolean canUseSkill, boolean hasItems) {
        System.out.println("Select Action:");
        System.out.println();
        System.out.println(" 1. Basic Attack");
        System.out.println(" 2. Defend");
        if (canUseSkill) System.out.println(" 3. Special Skill");
        if (hasItems)    System.out.println(" 4. Use Item");
        System.out.println();

        int maxOption = hasItems ? 4 : (canUseSkill ? 3 : 2);
        return readInt(1, maxOption);
    }

    public Combatant selectEnemyTarget(List<Combatant> enemies) {
        System.out.println("Select target:");
        System.out.println();

        List<Combatant> aliveEnemies = new ArrayList<>();
        for (Combatant e : enemies) {
            if (e.isAlive()) aliveEnemies.add(e);
        }

        for (int i = 0; i < aliveEnemies.size(); i++) {
            Combatant e     = aliveEnemies.get(i);
            String label    = enemyLabels.getOrDefault(e, "");
            String type     = e.getClass().getSimpleName();
            System.out.printf(" %d. %s %s  HP: %d/%d%n", i + 1, type, label, e.getCurrentHP(), e.getMaxHP());
        }
        System.out.println();

        int choice = readInt(1, aliveEnemies.size());
        System.out.println();
        return aliveEnemies.get(choice - 1);
    }

    public int selectItem(List<Item> availableItems) {
        System.out.println("Select item:");
        System.out.println();
        for (int i = 0; i < availableItems.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + availableItems.get(i).getName());
        }
        System.out.println();
        return readInt(1, availableItems.size()) - 1;
    }

    public void displayCompletionScreen(GameState state, int roundsSurvived, int remainingHP, int maxHP,
                                        int potionCount, int smokeBombCount, int powerStoneCount,
                                        Combatant player) {
        System.out.println();

        if (state.getResult() == GameState.BattleResult.VICTORY) {
            System.out.println("** Victory **");
            System.out.println("Congratulations, you have defeated all your enemies.");
        } else {
            System.out.println("** Defeat **");
            System.out.println("Defeated. Don't give up, try again!");
        }

        System.out.println("Remaining HP: " + remainingHP + "/" + maxHP
                + " | Total Rounds: " + roundsSurvived);

        if (player instanceof Warrior) {
            String potionText    = (potionCount > 0)    ? potionCount    + " <- unused" : "0";
            String smokeBombText = (smokeBombCount > 0) ? smokeBombCount + " <- unused" : "0";
            System.out.println("Remaining Potion: " + potionText
                    + " | Remaining Smoke Bomb: " + smokeBombText);
        } else if (player instanceof Wizard) {
            String stoneText  = (powerStoneCount > 0) ? powerStoneCount + " <- unused" : "0";
            String potionText = (potionCount > 0)     ? potionCount     + " <- unused" : "0";
            System.out.println("Remaining Power Stone: " + stoneText
                    + " | Remaining Potion: " + potionText);
            if (player.getAttack() > 50) {
                System.out.println("Final Wizard ATK: " + player.getAttack());
            }
        }

        System.out.println();
    }

    public boolean promptReplay() {
        System.out.print("Play again? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    // keeps re-asking until the user types a valid number in range
    private int readInt(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int value    = Integer.parseInt(input);
                if (value >= min && value <= max) return value;
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
