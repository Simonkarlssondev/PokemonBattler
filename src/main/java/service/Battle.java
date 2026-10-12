package service;

import model.Attack;
import model.BattleStats;
import model.Pokemon;
import util.InputHelper;

import java.util.Scanner;
import java.util.Random;


public class Battle {

    private Pokemon playerPokemon;
    private Pokemon enemyPokemon;
    private Scanner scanner;
    private Random random;
    private BattleStats stats;

    public Battle(Pokemon playerPokemon, Pokemon enemyPokemon, BattleStats stats, Scanner scanner) {
        this.playerPokemon = playerPokemon;
        this.enemyPokemon = enemyPokemon;
        this.scanner = scanner;
        this.random = new Random();
        this.stats = stats;
    }

    public void start() {
        System.out.println(playerPokemon.getName() + " vs " + enemyPokemon.getName());
        System.out.println(playerPokemon.getName() + " Starts!");

        if (playerPokemon.getAttacks().isEmpty() || enemyPokemon.getAttacks().isEmpty()) {
            System.out.println("Both model.Pokemon must have at least one attack!");
            return;
        }

        while (!playerPokemon.isDefeated() && !enemyPokemon.isDefeated()) {

            showPlayerAttacks();

            int attackChoice;

            try {
                attackChoice = chooseAttack();
            } catch (java.util.NoSuchElementException e) {
                System.out.println("\nInput ended. service.Battle aborted. ");
                return;
            }
            Attack selectedAttack = playerPokemon.getAttacks().get(attackChoice - 1);
            selectedAttack.execute(playerPokemon, enemyPokemon);

            System.out.println(enemyPokemon.getName() + " HP: " + enemyPokemon.getCurrentHp());

            if (enemyPokemon.isDefeated()) {
                break;
            }

            Attack enemyAttack = chooseEnemyAttack();
            enemyAttack.execute(enemyPokemon, playerPokemon);

            System.out.println(playerPokemon.getName() + " HP: " + playerPokemon.getCurrentHp());

        }
        if (playerPokemon.isDefeated()) {
            System.out.println(enemyPokemon.getName()+ " Wins! ");
            stats.addLoss();
        }else{
            System.out.println(playerPokemon.getName()+ " Wins! ");
            stats.addWin();
        }
    }

    private void showPlayerAttacks() {
        for (int i = 0; i < playerPokemon.getAttacks().size(); i++) {
            System.out.println((i + 1) + ". " + playerPokemon.getAttacks().get(i).getName());
        }
    }

    private int chooseAttack() {
        return InputHelper.readIntBetween(scanner, "Choose attack: ", 1, playerPokemon.getAttacks().size());

    }

    private Attack chooseEnemyAttack() {
        int attackIndex = random.nextInt(enemyPokemon.getAttacks().size());
        return enemyPokemon.getAttacks().get(attackIndex);
    }

}
