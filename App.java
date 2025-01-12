import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize player
        Player player = new Player("Hero", 100, 10, 5, 10);

        // Add weapons to the player
        player.addWeapon(new Weapon("Sword", 15, 0, new String[]{"Slash", "Stab"}));
        player.addWeapon(new Weapon("Staff", 10, 10, new String[]{"Magic Bolt", "Fireball"}));

        // Initialize enemy
        Enemy goblin = new Enemy("Goblin", 50, 8);

        // Start combat
        CombatSystem combat = new CombatSystem(scanner, player, goblin);
        combat.startCombat();
    }
}
