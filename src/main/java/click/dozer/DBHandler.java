package click.dozer;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by alexd on 16.10.2017.
 */
public class DBHandler {
    private static DBHandler instance = null;
    private Connection connection;

    private DBHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(Config.DB_URL);
    }

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null) instance = new DBHandler();
        return instance;
    }

    private HashMap<Integer, User> getAllUsers() {
        return null;
    }

    private HashMap<Integer, Event> getAllEvents() {
        return null;
    }
}
