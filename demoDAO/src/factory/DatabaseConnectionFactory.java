package factory;

import dbc.DatabaseConnection;

public class DatabaseConnectionFactory {
    public static DatabaseConnection getIDatabaseConnectionInstance(){
        return new DatabaseConnection();
    }
}
