package factory;

import dao.RmtUserDAO;
import dao.impl.IRmtUserDAO;

import java.sql.Connection;

public class DAOFactory {
    public static IRmtUserDAO getIRmtUserDAOInstance(Connection conn){
        return new RmtUserDAO(conn);
    }
}
