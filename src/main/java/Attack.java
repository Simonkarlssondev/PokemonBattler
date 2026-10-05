public abstract class Attack {
    private String name;
    private int damage;
    private int accuracy;
    private PokeElement type;

    public Attack(String name, int damage, int accuracy, PokeElement type) {
        setName(name);
        setDamage(damage);
        setAccuracy(accuracy);
        setType(type);

    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public PokeElement getType() {
        return type;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public void setDamage(int damage) {
        if (damage <= 0) {
            throw new IllegalArgumentException("Damage must be greater than 0");
        }
        this.damage = damage;
    }
    public void setAccuracy(int accuracy) {
        if (accuracy < 0 || accuracy > 100) {
            throw new IllegalArgumentException("Accuracy must be between 0 and 100");
        }
        this.accuracy = accuracy;
    }

    public void setType(PokeElement type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        this.type = type;

    }
    public abstract void execute(Pokemon attacker, Pokemon defender);

    @Override
    public String toString() {
        return name + " - Damage: " + damage + ", Accuracy: " + accuracy + ", Type: " + type;
    }

}
