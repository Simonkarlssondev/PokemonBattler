import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static int readInt(Scanner scanner, String prompt) {

        while (true) {

            System.out.print(prompt);

            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;


            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Unknown Input :");
            }

        }
    }


    public static int readIntBetween(Scanner scanner, String prompt, int min, int max) {

        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine();
            try {
                int value = Integer.parseInt(input.trim());

                if (value >= min && value <= max) {
                    return value;

                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }

            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a number.");
            }
        }

    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Unknown Input : ");

            }
        }
    }

}


