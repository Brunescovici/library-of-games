package org.games.library.database;

import org.games.library.model.Game;
import org.games.library.model.Helpers;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseServiceImplementation implements DatabaseService {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet result = null;


    public void connectToDatabase() {
        //Loading database Properties
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties dbProp = new Properties();
        try (InputStream properties = loader.getResourceAsStream("database_connection_info")) {
            dbProp.load(properties);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /*
         *  Establishing connection to the database
         */

        try {
            connection = DriverManager.getConnection(dbProp.getProperty("database") + dbProp.getProperty("database_name"), dbProp.getProperty("username"), dbProp.getProperty("password"));
            statement = connection.createStatement();
            System.out.println("Database connection successful!");
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    @Override
    public void showGame() {
        try {
            result = statement.executeQuery("select * from games where id=" + Integer.parseInt(Helpers.getInput("game's id")) + " and name='" + Helpers.getInput("game's name") + "'");
            Game game = new Game();
            while (result.next()) {
                    game.setID(result.getLong(1));
                    game.setName(result.getString(2));
                    game.setDescription(result.getString(3));
                    game.setPrice(result.getFloat(4));
                    game.setPriceType(result.getString(5));
                    game.setGameGenre(result.getString(6));
                    game.setChildFriendly(result.getBoolean(7));
                    game.setCreationDate(result.getDate(8));
                    game.setUpdateDate(result.getDate(9));
                }
            JOptionPane.showMessageDialog(null, "ID: " + game.getID() +
                    "\nName: " + game.getName() +
                    "\nDescription: " + game.getDescription() +
                    "\nPrice: $" + game.getPrice() +
                    "\nPrice type: " + game.getPriceType() +
                    "\nGenre: " + game.getGameGenre() +
                    "\nChild friendly: " + game.getChildFriendly() +
                    "\nCreation date: " + game.getCreationDate() +
                    "\nUpdate date: " + game.getUpdateDate()
                    );
            } catch(Exception var8){
                var8.printStackTrace();
            }
        }

        @Override
        public void showAllGames () {

        }

        @Override
        public void addGame () {
            try {
                statement.executeUpdate("INSERT INTO `games` " + "(name, description, price, price_type, genre, is_child_friendly) " +
                        "VALUES ('" + Helpers.getInput("game's name") + "', \"" +
                        Helpers.getInput("game's description") + "\", " +
                        Float.parseFloat(Helpers.getInput("game's price")) + ", '" +
                        Helpers.getInput("price_type") + "', '" +
                        Helpers.getInput("game's genre") + "', " +
                        Boolean.parseBoolean(Helpers.getInput("if the game is child friendly (0-for no, 1-for yes)")) + ");");
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }

        @Override
        public void closeConnection () {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Database disconnection successful!");
                } catch (Exception var8) {
                    var8.printStackTrace();
                }
            }
        }
    }
