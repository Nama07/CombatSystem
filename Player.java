import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int mana;
    private int maxMana;
    private int luck;
    private ArrayList<Weapon> weapons;
    private Weapon currentWeapon;

    public Player(String name, int health, int attack, int defense, int luck) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.luck = luck;
        this.mana = 50;  // Default mana
        this.maxMana = 50;
        this.weapons = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
        if (currentWeapon == null) {
            currentWeapon = weapon;
        }
    }

    public void switchWeapon(int index) {
        if (index >= 0 && index < weapons.size()) {
            currentWeapon = weapons.get(index);
            System.out.println("Switched to " + currentWeapon.getName());
        } else {
            System.out.println("Invalid weapon choice.");
        }
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void reduceHealth(int amount) {
        health -= amount;
        System.out.println(name + " takes " + amount + " damage. Health: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getMana() {
        return mana;
    }

    public void regenerateMana() {
        mana = Math.min(mana + 5, maxMana);
    }

    public void useMana(int amount) {
        mana -= amount;
    }

    // Getter methods
    public String getName() {
        return name;
    }
    public int getLuck() {
        return luck;
    }
}
