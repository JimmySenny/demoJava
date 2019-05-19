package dbc.impl;

import java.sql.Connection;

public interface IDatabaseConnection {
    /**
     * 获取数据库连接对象
     * @return
     */
    public Connection getConnection();

    /**
     * 关闭数据库连接
     */
    public void close();
}
