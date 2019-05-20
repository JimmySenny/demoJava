package Service.impl;

import vo.RmtUser;

import java.sql.SQLException;

public interface IService {
    /**
     * 校验用户名密码
     * @param vo 用户信息
     * @return true校验通过 否则false
     */
    public boolean isUserPwd( RmtUser vo) throws Exception;
}
