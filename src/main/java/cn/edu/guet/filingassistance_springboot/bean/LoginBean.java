package cn.edu.guet.filingassistance_springboot.bean;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.bean
 * @ClassName: LoginBean.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月04日 19:20:00
 */
public class LoginBean {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "LoginBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
