import java.util.Random;


public class DamageAttack extends Attack {

    public DamageAttack(String name, int damage, int accuracy, PokeElement type){
        super(name, damage, accuracy, type);
    }

    @Override
    public void execute(Pokemon attacker, Pokemon defender){
        Random random = new Random();
        int roll = random.nextInt(100) + 1 ;

        if (roll > getAccuracy()){
            System.out.println(attacker.getName() + " used " + getName() + ", but missed!");
            return;
        }
        System.out.println(attacker.getName() + " used " + getName() + "!");
        double multiplier = TypeEffectiveness.getMultiplier(getType(), defender.getType());
        double randomFactor = 0.85 + random.nextDouble() * 0.15;
        int damage = (int) (getDamage() * multiplier * randomFactor);

        defender.takeDamage(damage);
        System.out.println(defender.getName() + " took " + damage + " damage!");

    }

}
