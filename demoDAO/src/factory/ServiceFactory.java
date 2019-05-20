package factory;

import Service.ChkUserPwdService;
import Service.impl.IService;

public class ServiceFactory {
    public static IService getServiceInstance(){
        return new ChkUserPwdService();
    }
}
