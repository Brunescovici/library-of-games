package org.games.library;


import org.games.library.database.DatabaseServiceImplementation;

public class MainApp {
    public static void main(String[] args) {

        DatabaseServiceImplementation db = new DatabaseServiceImplementation();

        db.showGames();

        System.out.println("Hello World!");
    }
}
