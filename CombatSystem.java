import java.util.Random;
import java.util.Scanner;

public class CombatSystem {
    private Scanner scanner;
    private Player player;
    private Enemy enemy;
    private Random random;

    public CombatSystem(Scanner scanner, Player player, Enemy enemy) {
        this.scanner = scanner;
        this.player = player;
        this.enemy = enemy;
        this.random = new Random();
    }

    public void startCombat() {
        System.out.println("Combat starts! You are fighting a " + enemy.getName());

        while (player.isAlive() && !enemy.isDefeated()) {
            System.out.println("\nChoose an attack type:");
            Weapon weapon = player.getCurrentWeapon();
            String[] attackTypes = weapon.getAttackTypes();
            for (int i = 0; i < attackTypes.length; i++) {
                System.out.println((i + 1) + ". " + attackTypes[i]);
            }

            int choice = scanner.nextInt();
            if (choice < 1 || choice > attackTypes.length) {
                System.out.println("Invalid choice.");
                continue;
            }

            int damage = weapon.getDamage();
            String attackType = attackTypes[choice - 1];

            // If the weapon is magic
            if (weapon.getManaCost() > 0) {
                if (player.getMana() < weapon.getManaCost()) {
                    System.out.println("Not enough mana!");
                    continue;
                }

                if (!solveMathProblem()) {
                    System.out.println("Math problem failed. Attack missed!");
                    continue;
                }

                player.useMana(weapon.getManaCost());
            }

            // Critical hit chance
            boolean criticalHit = random.nextInt(100) < player.getLuck();
            if (criticalHit) {
                damage *= 2;
                System.out.println("Critical hit!");
            }

            System.out.println("You used " + attackType + " and dealt " + damage + " damage!");
            enemy.takeDamage(damage);

            // Enemy attacks
            if (!enemy.isDefeated()) {
                int enemyDamage = random.nextInt(enemy.getAttackDamage());
                System.out.println(enemy.getName() + " attacks for " + enemyDamage + " damage!");
                player.reduceHealth(enemyDamage);
            }

            player.regenerateMana();
        }

        if (!player.isAlive()) {
            System.out.println("You were defeated...");
        } else {
            System.out.println("You defeated the " + enemy.getName() + "!");
        }
    }

    private boolean solveMathProblem() {
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        char[] operators = {'+', '-', '*'};
        char operator = operators[random.nextInt(3)];

        int correctAnswer = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> 0;
        };

        System.out.println("Solve this: " + num1 + " " + operator + " " + num2);
        int playerAnswer = scanner.nextInt();

        return playerAnswer == correctAnswer;
    }
}
