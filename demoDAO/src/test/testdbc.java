package test;

import dbc.DatabaseConnection;
import dbc.impl.IDatabaseConnection;
import factory.DAOFactory;
import factory.DatabaseConnectionFactory;
import factory.ServiceFactory;
import vo.RmtUser;

import java.sql.Connection;

public class testdbc {
    public static void main(String[] args){
        /*
        DatabaseConnection conn = new DatabaseConnection();
        System.out.println(conn.toString());
        System.out.println(DAOFactory.getIRmtUserDAOInstance(DatabaseConnectionFactory.getIDatabaseConnectionInstance().getConnection()).findByid( "000" ).toString());
         */
        RmtUser vo1 = new RmtUser("000", "000");
        RmtUser vo2 = new RmtUser("000", "001");
        try {
            System.out.println("TEST" + DAOFactory.getIRmtUserDAOInstance(DatabaseConnectionFactory.getIDatabaseConnectionInstance().getConnection()).findByid(vo2.getUser_id()).toString());
            System.out.printf("isUserPwd1\t" + ServiceFactory.getServiceInstance().isUserPwd(vo1));
            System.out.printf("isUserPwd2\t" + ServiceFactory.getServiceInstance().isUserPwd(vo2));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
