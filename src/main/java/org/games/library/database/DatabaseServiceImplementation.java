package org.games.library.database;

import java.util.logging.Logger;

public class DatabaseServiceImplementation implements DatabaseService {

    private final static Logger logger = Logger.getLogger(DatabaseServiceImplementation.class.getName());

    @Override
    public void showGames() {
        logger.info("hello brun");
    }

    @Override
    public void showAllGames() {

    }

    @Override
    public void addGame() {

    }
}
