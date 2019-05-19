package dao.impl;

import vo.RmtUser;

public interface IRmtUserDAO {
    public RmtUser findByid(String user_id) throws Exception;
}
