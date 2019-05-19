package test;

import dbc.DatabaseConnection;
import dbc.impl.IDatabaseConnection;
import factory.DAOFactory;
import factory.DatabaseConnectionFactory;

import java.sql.Connection;

public class testdbc {
    public static void main(String[] args) throws Exception{
        DatabaseConnection conn = new DatabaseConnection();
        System.out.println(conn.toString());
        System.out.println(DatabaseConnectionFactory.getIDatabaseConnectionInstance().toString());
        DatabaseConnection conn1= DatabaseConnectionFactory.getIDatabaseConnectionInstance();
        System.out.println(DAOFactory.getIRmtUserDAOInstance(conn1.getConnection()).findByid("000").toString());


    }
}
