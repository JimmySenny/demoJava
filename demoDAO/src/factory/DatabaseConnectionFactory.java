package factory;

import dbc.DatabaseConnection;
import dbc.impl.IDatabaseConnection;

import java.sql.Connection;

public class DatabaseConnectionFactory {
    public static DatabaseConnection getIDatabaseConnectionInstance(){
        //return new DatabaseConnection();
        DatabaseConnection conn = new DatabaseConnection();
        return conn;
    }
}
