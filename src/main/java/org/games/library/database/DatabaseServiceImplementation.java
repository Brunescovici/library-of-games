package org.games.library.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseServiceImplementation implements DatabaseService {

    private final static Logger logger = Logger.getLogger(DatabaseServiceImplementation.class.getName());
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
//        finally {
//            if (result != null) {
//                try {
//                    result.close();
//                } catch (Exception var8) {
//                    var8.printStackTrace();
//                }
//            }
//
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (Exception var8) {
//                    var8.printStackTrace();
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (Exception var8) {
//                    var8.printStackTrace();
//                }
//            }
//        }
    }

    @Override
    public void showGames(int id, String name) {
        logger.info("hello brun");
        try {
            result = statement.executeQuery("select * from games where id=" + id + " and name='" + name + "'");
            while (result.next()) {
                int columnsNumber = result.getMetaData().getColumnCount();
                for(int i=1; i<=columnsNumber; i++){
                    System.out.println(result.getMetaData().getColumnName(i)+": "+ result.getString(i));
                }
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    @Override
    public void showAllGames() {

    }

    @Override
    public void addGame() {

    }

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }
    }
}
