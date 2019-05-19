package dao;

import dao.impl.IRmtUserDAO;
import vo.RmtUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RmtUserDAO implements IRmtUserDAO {
    private Connection conn;
    private PreparedStatement pstmt;

    public RmtUserDAO(Connection conn){
        this.conn = conn;
    }
    @Override
    public RmtUser findByid(String user_id) throws Exception {
        RmtUser vo = null;
        String sql = "SELECT user_id, user_pwd FROM tb_rmt_user where user_id=? ";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,user_id);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            vo = new RmtUser();
            vo.setUser_id(rs.getString(1 ));
            vo.setUser_pwd(rs.getString(2 ));
        }
        return vo;
    }
}
