import java.util.List;

public class MagicWeapon extends Weapon {
    private List<String> magicEffects;

    public MagicWeapon(String name, int damage, int manaCost, String[] attackTypes, List<String> magicEffects) {
        super(name, damage, manaCost, attackTypes);
        this.magicEffects = magicEffects;
    }

    public List<String> getMagicEffects() {
        return magicEffects;
    }
}
