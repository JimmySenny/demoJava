package dbc;

import dbc.impl.IDatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements IDatabaseConnection {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/rmtdb?useUnicode=true＆characterEncoding=utf-8＆useSSL=false&serverTimezone=UTC";
    private static final String DBUSER = "root";
    private static final String DBPWD= "password";
    private Connection conn = null;

    /**
     * 构造MySQL驱动的数据库连接
     */
    public DatabaseConnection(){
        try{
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPWD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    /**
     * 获取连接
     * @return Connection实例化对象
     */
    public Connection getConnection(){
        return this.conn;
    }

    @Override
    /**
     * 关闭连接
     */
    public void close(){
        if(this.conn != null){
            try{
                this.conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            this.conn = null;
        }

    }
}
