package org.games.library;


import org.games.library.database.DatabaseServiceImplementation;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        DatabaseServiceImplementation db = new DatabaseServiceImplementation();

        db.connectToDatabase();
        db.showGames(2, "Spore");
        db.closeConnection();

        System.out.println("Hello World!");
    }
}
