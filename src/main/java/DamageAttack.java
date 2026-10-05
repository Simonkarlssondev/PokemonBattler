public class DamageAttack extends Attack {

    public DamageAttack(String name, int damage, int accuracy, PokeElement type){
        super(name, damage, accuracy, type);
    }

    @Override
    public void execute(Pokemon attacker, Pokemon defender){
        defender.takeDamage(getDamage());

    }

}
