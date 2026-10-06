
import java.util.ArrayList;

public class Pokemon {

    private String name;
    private PokeElement type;
    private int maxHp;
    private int currentHp;
    private ArrayList<Attack> attacks = new ArrayList<>();

    public Pokemon(String name, PokeElement type, int maxHp, int currentHp) {
        setName(name);
        setType(type);
        setMaxHp(maxHp);
        setCurrentHp(currentHp);

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public PokeElement getType() {
        return type;
    }

    public void setType(PokeElement type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        this.type = type;
    }

    public int getMaxHp() {
        return maxHp;
    }
    public void setMaxHp(int maxHp) {
        if (maxHp <= 0) {
            throw new IllegalArgumentException("Max HP must be greater than 0");
        }
        this.maxHp = maxHp;
    }
    public int getCurrentHp() {
        return currentHp;
    }
    public void setCurrentHp(int currentHp) {
        if (currentHp < 0 || currentHp > maxHp) {
            throw new IllegalArgumentException("Current HP must be between 0 and max HP");
        }
        this.currentHp = currentHp;
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }
    public void addAttack(Attack attack) {
        if (attack == null) {
            throw new IllegalArgumentException("Attack cannot be null");
        }
        attacks.add(attack);
    }

    public void takeDamage(int damage) {
        currentHp -= damage;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }
    public boolean isDefeated() {
        return currentHp <= 0;
    }


    @Override
    public String toString() {
        return name + " (" + type + ") - HP: " + currentHp + "/" + maxHp;
    }




}

