public class Main {
    public static void main(String[] args) {

        Pokemon attacker = new Pokemon("Pickachu", PokeElement.ELECTRIC, 200,200);
        Pokemon defender = new Pokemon("Snorlax", PokeElement.NORMAL, 200,200);

        Attack attack = new DamageAttack("Thunderbolt", 50,100, PokeElement.ELECTRIC);

        attack.execute(attacker, defender);

        System.out.println(defender.getCurrentHp());

    }
}
