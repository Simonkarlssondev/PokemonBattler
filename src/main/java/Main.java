public class Main {
    public static void main(String[] args) {
        PokeAttacks.seedAttacks();

        Pokemon pickachu = new Pokemon("Pikachu", PokeElement.ELECTRIC, 200, 200);
        pickachu.addAttack(PokeAttacks.attacks.get(6));
        pickachu.addAttack(PokeAttacks.attacks.get(7));
        pickachu.addAttack(PokeAttacks.attacks.get(8));





        Pokemon snorlax = new Pokemon("Snorlax", PokeElement.NORMAL, 200, 200);

        Battle battle = new Battle(pickachu, snorlax);

        battle.start();





    }
}
