# PokemonBattler

PokemonBattler is a Java console application where the player can manage a collection of Pokémon and battle against computer-controlled opponents.

## Features
- Manage a collection of Pokémon.
- Battle randomly selected opponents.
- Choose attacks during turn-based battles.
- Calculate damage using attack power, type effectiveness, and a random factor.
- Check attack accuracy to determine whether attacks hit or miss.
- Save Pokémon data and battle statistics to files.
- Display battle results and statistics.

## Technologies
- Java 21
- Maven

## Object-Oriented Programming
The project uses separate classes to organize Pokémon, attacks, battles, and data storage. Packages such as `model`, `service`, `data`, and `util` help keep responsibilities separated.

`DamageAttack` extends `Attack` and overrides the `execute` method. This demonstrates inheritance and polymorphism.

## Additional Features
Type effectiveness is implemented for selected Pokémon type matchups.

## VG Features Attempted
- Type effectiveness for selected Pokémon type matchups.


## How to Run
Open the project in IntelliJ IDEA and run the `Main` class.

## Damage Calculation
Damage is calculated by multiplying the attack's base damage by the type effectiveness multiplier and a random factor between 0.85 and 1.0. The result is converted to an integer. Attacks also have an accuracy check that determines whether they hit or miss.

## Battle Turn Order
The player always takes the first turn. After the player's attack, the CPU attacks if its Pokémon has not been defeated.

## Known Limitations
The application uses text files for persistence. Type effectiveness and other battle mechanics are limited to the implemented rules.