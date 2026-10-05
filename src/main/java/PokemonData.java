import java.util.ArrayList;

public class PokemonData {
    static ArrayList<Pokemon> pokemons = new ArrayList<>();
    public static void seedData() {
        PokeAttacks.seedAttacks();

        Pokemon charizard = new Pokemon("Charizard", PokeElement.FIRE, 200,200);
        pokemons.add(charizard);
        charizard.addAttack(PokeAttacks.attacks.get(0));
        charizard.addAttack(PokeAttacks.attacks.get(1));
        charizard.addAttack(PokeAttacks.attacks.get(2));


        Pokemon blastoise = new Pokemon("Blastoise", PokeElement.WATER, 200,200);
        pokemons.add(blastoise);
        blastoise.addAttack(PokeAttacks.attacks.get(3));
        blastoise.addAttack(PokeAttacks.attacks.get(4));
        blastoise.addAttack(PokeAttacks.attacks.get(5));


        Pokemon pikachu = new Pokemon("Pikachu", PokeElement.ELECTRIC, 200,200);
        pokemons.add(pikachu);
        pikachu.addAttack(PokeAttacks.attacks.get(6));
        pikachu.addAttack(PokeAttacks.attacks.get(7));
        pikachu.addAttack(PokeAttacks.attacks.get(8));


        Pokemon venusaur = new Pokemon("Venusaur", PokeElement.GRASS, 200,200);
        pokemons.add(venusaur);
        venusaur.addAttack(PokeAttacks.attacks.get(9));
        venusaur.addAttack(PokeAttacks.attacks.get(10));
        venusaur.addAttack(PokeAttacks.attacks.get(11));


        Pokemon lapras = new Pokemon("Lapras", PokeElement.ICE, 200,200);
        pokemons.add(lapras);
        lapras.addAttack(PokeAttacks.attacks.get(12));
        lapras.addAttack(PokeAttacks.attacks.get(13));
        lapras.addAttack(PokeAttacks.attacks.get(14));


        Pokemon snorlax = new Pokemon("Snorlax", PokeElement.NORMAL, 200,200);
        pokemons.add(snorlax);
        snorlax.addAttack(PokeAttacks.attacks.get(15));
        snorlax.addAttack(PokeAttacks.attacks.get(16));
        snorlax.addAttack(PokeAttacks.attacks.get(17));




    }
}
