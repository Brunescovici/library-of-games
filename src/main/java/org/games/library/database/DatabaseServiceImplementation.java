package org.games.library.database;

import org.games.library.model.Game;
import org.games.library.utilities.Helpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseServiceImplementation implements DatabaseService {

    private Connection connection = null;
    private PreparedStatement statement = null;


    /**
     * documenteaza metoda
     */
    @Override
    public void connectToDatabase() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties dbProp = new Properties();
        try (InputStream properties = loader.getResourceAsStream("database_connection_info")) {
            dbProp.load(properties);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(
                    dbProp.getProperty("database") + dbProp.getProperty("database_name"),
                    dbProp.getProperty("username"), dbProp.getProperty("password"));
            System.out.println("Database connection successful!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showGame() {

    }

    @Override
    public void showAllGames() {


    }

    @Override
    public void addGame() {
        try {
            Game game = Helpers.createGame();
            statement = connection.prepareStatement("INSERT INTO `games` (name, description, price, price_type, genre, is_child_friendly)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, game.getName());
            statement.setString(2, game.getDescription());
            statement.setFloat(3, game.getPrice());
            statement.setString(4, game.getPriceType());
            statement.setString(5, game.getGameGenre());
            statement.setInt(6, game.getIsChildFriendly());
            try {
                statement.executeUpdate();
                System.out.println(game.getName() + " has been successfully added to the library.");
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Game already exists.");
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database disconnection successful!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
