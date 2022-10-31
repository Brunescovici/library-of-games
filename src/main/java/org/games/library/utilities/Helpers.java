package org.games.library.utilities;


import org.games.library.model.Game;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helpers {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static Scanner scanner = new Scanner(System.in);


    public static Game createGame() {
        System.out.print("Please enter a name: ");
        String name = "";
        try {
            name = scanner.nextLine();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
        name = stringValidation(name);
        System.out.print("Please enter a description: ");
        String description = "";
        try {
            description = scanner.nextLine();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
        description = stringValidation(description);
        System.out.print("Please enter the price of the game in USD:");
        float price = 0;
        try {
            price = scanner.nextFloat();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid value.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception ", e);
        }
        price = priceValidation(price);
        System.out.print("Please enter the game genre:");
        String genre = "";
        try {
            genre = scanner.nextLine().toUpperCase();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
        genre = stringValidation(genre).toUpperCase();
        while(!genreValidation(genre)) {
            System.out.println("Please enter a valid genre: ");
            genre = scanner.nextLine().toUpperCase();
            genre = stringValidation(genre).toUpperCase();
        }
        System.out.print("Please enter 1 if the game is child-friendly, and 0 if it is not:");
        int childFriendly = 0;
        try {
            childFriendly = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
        childFriendly = childFriendlyValidation(childFriendly);
        return new Game.GameBuilder(name, description, price)
                .gameGenre(genre)
                .isChildFriendly(childFriendly)
                .build();
    }

    /**
     *
     * VALIDATORS FOR GAME OBJECT CREATION
     *
     */
    public static String stringValidation(String string) {
        while (string.equals("") || (string.contains("ARPG") && string.contains("RPG"))) {
            try {
                System.out.println("Not valid, please try again: ");
                string = scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid value.");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception: ", e);
            }
        }
        return string;
    }

    public static float priceValidation(float price) {
        while (price < 0) {
            try {
                System.out.println("Not valid, please try again: ");
                price = scanner.nextFloat();
                scanner.nextLine();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception: ", e);
            }
        }
        return price;
    }

    public static int childFriendlyValidation(int childFriendly) {
        while (childFriendly != 0 && childFriendly != 1) {
            try {
                System.out.println("Not valid, please try again: ");
                childFriendly = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception: ", e);
            }
        }
        return childFriendly;
    }

    public static boolean genreValidation(String genre) {
        String[] genres = genre.split(", ", -1);
        for (String gen : genres
        ) {
            boolean valid = false;
            for (GenreTypes genType : GenreTypes.values()
            ) {
                if (genType.name().equals(gen)) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                return false;
        }
        return true;
    }

}
