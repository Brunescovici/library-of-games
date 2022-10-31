package org.games.library;


import org.games.library.database.DatabaseServiceImplementation;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DatabaseServiceImplementation db = new DatabaseServiceImplementation();

        db.connectToDatabase();

        String choice;
        boolean quit = false;
        while(!quit) {
            //Choosing an option
            System.out.println("""
                    Please choose:
                    1. Add a new game to the library
                    2. Show a game by its name or id
                    3. Quit""");
            choice = scanner.nextLine();

            switch (choice.charAt(0)) {
                case '1' -> db.addGame();
                case '2' -> db.showGame();
                case '3' -> {
                    System.out.println("Good bye!");
                    quit = true;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }

        db.closeConnection();
    }
}
