package data;

import model.BattleStats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;



public class BattleStatsStorage {

    private static final String FILE_NAME = "battle_stats.txt";

    public static void save(BattleStats stats) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(stats.getWins() + "\n");
            writer.write(stats.getLosses() + "\n");

        } catch (IOException e) {
            System.out.println("Could not save battle stats: " + e.getMessage());
        }

    }

    public static void load(BattleStats stats) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
           String winsLine = reader.readLine();
           String lossesLine = reader.readLine();

           if (winsLine == null || lossesLine == null) {
               System.out.println("Battle stats file is empty or incomplete.");
               return;
           }
           int wins = Integer.parseInt(winsLine);
           int losses = Integer.parseInt(lossesLine);

           if (wins < 0 || losses < 0 ) {
               System.out.println("Battle stats cannot be negative.");
               return;
           }
           stats.setWins(wins);
           stats.setLosses(losses);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load battle stats: " + e.getMessage());
        }

    }
}