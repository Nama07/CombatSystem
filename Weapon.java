public class Weapon {
    private String name;
    private int damage;
    private int manaCost;
    private String[] attackTypes;

    public Weapon(String name, int damage, int manaCost, String[] attackTypes) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.attackTypes = attackTypes;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String[] getAttackTypes() {
        return attackTypes;
    }
}
