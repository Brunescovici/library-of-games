package org.games.library.database;

public interface DatabaseService {
    void connectToDatabase();
    void showGames(int id, String name);
    void showAllGames();
    void addGame();
    void closeConnection();
}
