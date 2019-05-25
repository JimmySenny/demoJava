package demo.StructuralPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

class ConnectionPool {

    private Vector<Connection> pool;

    /*公有属性*/
    private static final String DBDRIVER1 = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/rmtdb?useUnicode=true & characterEncoding=utf-8 & useSSL=false & serverTimezone=UTC";
    private static final String DBUSER = "root";
    private static final String DBPWD= "password";

    private int poolSize = 100;
    private static ConnectionPool instance = null;
    Connection conn = null;

    private int poolCount = 100;

    /*构造方法，做一些初始化工作*/
    private ConnectionPool() {
        pool = new Vector<Connection>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(DBDRIVER1);
                conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
                pool.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /* 返回连接到连接池 */
    public synchronized void release(Connection conn) {
        if(conn != null){
            pool.add(conn);
            this.poolCount++;
        }
    }

    /* 返回连接池中的一个数据库连接 */
    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection conn = pool.get(0);
            pool.remove(conn);
            this.poolCount--;
            return conn;
        } else {
            return null;
        }
    }

    public static ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public int getPoolCount() {
        return poolCount;
    }

    public Enumeration<Connection> getPool() {
        return pool.elements();
    }
}

public class FlyweightTest{
    public static void main(String[] args) {
        ConnectionPool cp = ConnectionPool.getInstance();
        Enumeration<Connection> enu = cp.getPool();

        System.out.println(cp.getPoolCount());
        System.out.println(enu.nextElement());
        System.out.println(enu.nextElement());
        System.out.println(enu.nextElement());
        System.out.println(enu.nextElement());
        System.out.println(enu.nextElement());

        Connection conn1 = cp.getConnection();
        Connection conn2 = cp.getConnection();
        Connection conn3 = cp.getConnection();
        Connection conn4 = cp.getConnection();

        enu = cp.getPool();
        System.out.println(cp.getPoolCount());
        System.out.println(enu.nextElement());

        cp.release(conn1);
        cp.release(conn2);

        enu = cp.getPool();
        System.out.println(cp.getPoolCount());
        System.out.println(enu.nextElement());
    }
}
