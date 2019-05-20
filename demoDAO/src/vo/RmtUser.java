package vo;

import java.util.Objects;

public class RmtUser {


    String user_id;
    String user_pwd;

    public RmtUser() {

    }
    public RmtUser(String user_id,String user_pwd){
        this.user_id = user_id;
        this.user_pwd = user_pwd;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    @Override
    public String toString() {
        return "RmtUser{" +
                "user_id='" + user_id + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RmtUser rmtUser = (RmtUser) o;
        return Objects.equals(user_id, rmtUser.user_id) &&
                Objects.equals(user_pwd, rmtUser.user_pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_pwd);
    }
}
