import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Pokedex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PokemonData.seedData();

        if (new java.io.File("pokedex.csv").exists()) {
            loadFromFile();
        }

        while (true) {
            System.out.println("==== Pokedex ====\n1. All Pokemons\n2. Add Pokemon\n3. Edit Pokemon\n4. Delete Pokemon\n5. Save to file\n6. Load from file\n7. Reset to seeded data\n8. Exit");

            int val = InputHelper.readIntBetween(scanner, " Choose: ", 1, 8);

            switch (val) {
                case 1 -> displayAllPokemons();
                case 2 -> addPokemon(scanner);
                case 3 -> editPokemon(scanner);
                case 4 -> delPokemon(scanner);
                case 5 -> saveToFile();
                case 6 -> loadFromFile();
                case 7 -> resetSeedData();
                case 8 -> {
                    saveToFile();
                    exitProgram();
                    scanner.close();
                    return;
                }


            }
        }
    }

    public static void displayAllPokemons() {

        for (Pokemon pokemon : PokemonData.pokemons) {
            System.out.println("=====================");
            System.out.println(pokemon.getName());
            System.out.println(pokemon.getType());
            System.out.println("Max HP: " + pokemon.getMaxHp());
            System.out.println("Current HP: " + pokemon.getCurrentHp());

            for (Attack attack : pokemon.getAttacks()) {
                System.out.println("Attack: " + attack.getName());
                System.out.println("Damage: " + attack.getDamage());
                System.out.println("Accuracy: " + attack.getAccuracy());
                System.out.println("Type: " + attack.getType());


            }
            System.out.println("=====================\n");
        }

    }

    public static void addPokemon(Scanner scanner) {
        String name;

        do {
            System.out.print("Name your Pokemon: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Pokemon name cannot be empty");
            }
        } while (name.isEmpty());

        System.out.print("Enter max HP: ");
        int maxHp = InputHelper.readIntBetween(scanner, "", 1, 1000);

        int currentHp = maxHp;

        System.out.println("Choose Pokemon type: ");
        System.out.println("1. FIRE");
        System.out.println("2. WATER");
        System.out.println("3. ELECTRIC");
        System.out.println("4. GRASS");
        System.out.println("5. ICE");
        System.out.println("6. NORMAL");

        int typeChoice = InputHelper.readIntBetween(scanner, "Choose: ", 1, 6);

        PokeElement type;
        switch (typeChoice) {
            case 1 -> type = PokeElement.FIRE;
            case 2 -> type = PokeElement.WATER;
            case 3 -> type = PokeElement.ELECTRIC;
            case 4 -> type = PokeElement.GRASS;
            case 5 -> type = PokeElement.ICE;
            case 6 -> type = PokeElement.NORMAL;
            default -> type = PokeElement.NORMAL;

        }

        Pokemon pokemon = new Pokemon(name, type, maxHp, currentHp);
        System.out.println("Choose attacks for your Pokemon: ");

        for (int i = 0; i < PokeAttacks.attacks.size(); i++) {
            System.out.println((i + 1) + ". " + PokeAttacks.attacks.get(i).getName());
        }
        System.out.print("How many attacks do you want to add?: ");
        int attackCount = InputHelper.readIntBetween(scanner, "", 1, 4);

        for (int i = 0; i < attackCount; i++) {
            System.out.print("Choose attack " + (i + 1) + ": ");
            int attackChoice = InputHelper.readIntBetween(scanner, "", 1, PokeAttacks.attacks.size());
            pokemon.addAttack(PokeAttacks.attacks.get(attackChoice - 1));
        }


        PokemonData.pokemons.add(pokemon);


    }

    public static void editPokemon(Scanner scanner) {
        if (PokemonData.pokemons.isEmpty()) {
            System.out.println("There are no Pokemon to edit.");
            return;
        }


        System.out.println("Choose a Pokemon to edit: ");

        for (int i = 0; i < PokemonData.pokemons.size(); i++) {
            System.out.println((i + 1) + ". " + PokemonData.pokemons.get(i).getName());
        }
        int pokemonChoice = InputHelper.readIntBetween(scanner, "Choose: ", 1, PokemonData.pokemons.size());

        Pokemon pokemon = PokemonData.pokemons.get(pokemonChoice - 1);
        System.out.println("What do you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Max HP");
        System.out.println("3. Type");
        System.out.println("4. Add attack");
        System.out.println("5. Remove attack");

        int editChoice = InputHelper.readIntBetween(scanner, "Choose: ", 1, 5);
        switch (editChoice) {
            case 1 -> {
                String newName;
                do {
                    System.out.print("Enter new name: ");
                    newName = scanner.nextLine().trim();

                    if (newName.isEmpty()) {
                        System.out.println("Pokemon name cannot be empty");
                    }
                } while (newName.isEmpty());
                pokemon.setName(newName);

            }
            case 2 -> {
                System.out.print("Enter new max HP: ");
                int newMaxHp = InputHelper.readIntBetween(scanner, "", 1, 1000);
                pokemon.setMaxHp(newMaxHp);
                pokemon.setCurrentHp(newMaxHp);
            }
            case 3 -> {
                System.out.println("Choose new type: ");
                System.out.println("1. FIRE");
                System.out.println("2. WATER");
                System.out.println("3. ELECTRIC");
                System.out.println("4. GRASS");
                System.out.println("5. ICE");
                System.out.println("6. NORMAL");
                int newTypeChoice = InputHelper.readIntBetween(scanner, "Choose: ", 1, 6);

                switch (newTypeChoice) {
                    case 1 -> pokemon.setType(PokeElement.FIRE);
                    case 2 -> pokemon.setType(PokeElement.WATER);
                    case 3 -> pokemon.setType(PokeElement.ELECTRIC);
                    case 4 -> pokemon.setType(PokeElement.GRASS);
                     case 5 -> pokemon.setType(PokeElement.ICE);
                    case 6 -> pokemon.setType(PokeElement.NORMAL);

                }
            }
            case 4 -> {
                if (pokemon.getAttacks().size() >= 4) {
                    System.out.println("Your Pokemon already has 4 attacks.");
                } else {
                    System.out.println("Choose an attack to add: ");

                    for (int i = 0; i < PokeAttacks.attacks.size(); i++) {
                        System.out.println((i + 1) + ". " + PokeAttacks.attacks.get(i).getName());
                    }
                    int attackChoice = InputHelper.readIntBetween(scanner, "Choose: ", 1, PokeAttacks.attacks.size());
                    pokemon.addAttack(PokeAttacks.attacks.get(attackChoice - 1));
                }

            }
            case 5 -> {
                if (pokemon.getAttacks().size() <= 1) {
                    System.out.println("Pokemon must have at least 1 attack.");

                } else {
                    System.out.println("Choose an attack to remove: ");

                    for (int i = 0; i < pokemon.getAttacks().size(); i++) {
                        System.out.println((i + 1) + ". " + pokemon.getAttacks().get(i).getName());
                    }
                    int attackChoice = InputHelper.readIntBetween(scanner, "Choose: ", 1, pokemon.getAttacks().size());
                    pokemon.getAttacks().remove(attackChoice - 1);

                }

            }
        }


    }

    public static void delPokemon(Scanner scanner) {
        if (PokemonData.pokemons.isEmpty()) {
            System.out.println("There are no Pokemon to delete.");
            return;
        }
        System.out.println("Choose a Pokemon to delete: ");

        for (int i = 0; i < PokemonData.pokemons.size(); i++) {
            System.out.println((i + 1) + ". " + PokemonData.pokemons.get(i).getName());
        }
        int pokemonChoice = InputHelper.readIntBetween(scanner, "Choose: ", 1, PokemonData.pokemons.size());
        PokemonData.pokemons.remove(pokemonChoice - 1);

    }

    public static void saveToFile() {
        try (FileWriter writer = new FileWriter("pokedex.csv")) {
            for (Pokemon pokemon : PokemonData.pokemons) {
                writer.write(pokemon.getName() + ";" + pokemon.getType() + ";" + pokemon.getMaxHp() + ";" + pokemon.getCurrentHp() + ";");

                for (int i = 0; i < pokemon.getAttacks().size(); i++) {
                    if (i > 0) {
                        writer.write("|");


                    }
                    writer.write(pokemon.getAttacks().get(i).getName());

                }
                writer.write("\n");

            }


        } catch (IOException e) {
            System.out.println("Could not save the Pokemon");
        }

    }

    public static void loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("pokedex.csv"))) {
            ArrayList<Pokemon> loadedPokemons = new ArrayList<>();


            String line;
            while ((line = reader.readLine()) != null) {


                String[] parts = line.split(";");
                if (parts.length != 5) {
                    throw new IllegalArgumentException("Invalid CSV format");
                }

                int maxHp = Integer.parseInt(parts[2]);
                int currentHp = Integer.parseInt(parts[3]);

                if (maxHp <= 0 || maxHp > 1000 || currentHp <= 0 || currentHp > maxHp) {
                    throw new IllegalArgumentException("Invalid HP ");
                }


                String name = parts[0];

                if (name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Pokemon name cannot be empty");
                }

                PokeElement type = PokeElement.valueOf(parts[1]);
                Pokemon pokemon = new Pokemon(name, type, maxHp, currentHp);
                String[] attackNames = parts[4].split("\\|");

                for (String attackName : attackNames) {

                    boolean found = false;

                    for (Attack attack : PokeAttacks.attacks) {

                        if (attack.getName().equals(attackName)) {
                            pokemon.getAttacks().add(attack);
                            found = true;

                        }

                    }

                    if (!found) {
                        throw new IllegalArgumentException("Unknown attack");
                    }

                }
                if (pokemon.getAttacks().size() < 1 || pokemon.getAttacks().size() > 4) {
                    throw new IllegalArgumentException("Invalid number of attacks");
                }
                loadedPokemons.add(pokemon);
            }
            if (!loadedPokemons.isEmpty()) {
                PokemonData.pokemons.clear();
                PokemonData.pokemons.addAll(loadedPokemons);
            }


        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Could not load the Pokemon");
        }
    }

    public static void resetSeedData() {
        PokemonData.pokemons.clear();
        PokemonData.seedData();


    }


    public static void exitProgram() {
        System.out.println("Program closed! ");
    }
}