package org.games.library.database;

public interface DatabaseService {
    void connectToDatabase();
    void showGame();
    void showAllGames();
    void addGame();
    void closeConnection();
}
