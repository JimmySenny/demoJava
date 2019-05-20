package Service;

import Service.impl.IService;
import dbc.DatabaseConnection;
import factory.DAOFactory;
import factory.DatabaseConnectionFactory;
import vo.RmtUser;

public class ChkUserPwdService implements IService {
    private DatabaseConnection dbc = DatabaseConnectionFactory.getIDatabaseConnectionInstance();
    private RmtUser ret_vo_rmtuser = new RmtUser();
    public ChkUserPwdService(){
    }
    @Override
    public boolean isUserPwd(RmtUser vo) throws Exception {
        Connction conn  = null;

        try{

           // conn =
            System.out.println(this.dbc.getConnection().equals( this.dbc.getConnection() ) );

            if( (ret_vo_rmtuser = DAOFactory.getIRmtUserDAOInstance( this.dbc.getConnection()).findByid(vo.getUser_id())) == null ){
               return false;
            }
            System.out.println("ChkUserPwd()\t" + vo.toString() + ",ret\t" + ret_vo_rmtuser.toString());
            if (true == ret_vo_rmtuser.equals(vo)) {
                System.out.println("ChkUserPwd return true!");
                return true;
            }
            System.out.println("ChkUserPwd return false!");
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.dbc.close();
        }
        System.out.println("ChkUserPwd return false! end");
        return false;
    }
}
