package org.games.library;


import org.games.library.database.DatabaseServiceImplementation;

import javax.swing.*;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        DatabaseServiceImplementation db = new DatabaseServiceImplementation();

        db.connectToDatabase();

        String choice;
        boolean quit = false;
        do {
            //Choosing an option
            choice = JOptionPane.showInputDialog("You have the following options:\n"+
                    "1. Add a game into the database\n"+
                    "2. Show a game knowing it's ID and it's name\n"+
                    "3. Quit"
                    );

            switch (choice) {
                case "1":
                    db.addGame();
                    break;
                case "2":
                    db.showGame();
                    break;
                case "3":
                    quit = true;
                    JOptionPane.showMessageDialog(null,"Have a nice day!");
                    break;
            }
        } while (!quit);

        db.closeConnection();
    }
}
