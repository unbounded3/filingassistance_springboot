package cn.edu.guet.filingassistance_springboot.bean;

import java.util.Objects;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.bean
 * @ClassName: SignUpBean.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月12日 17:20:00
 */
public class SignUpBean {
    private String username;
    private String idCard;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUpBean that = (SignUpBean) o;
        return Objects.equals(username, that.username) && Objects.equals(idCard, that.idCard) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, idCard, password);
    }

    @Override
    public String toString() {
        return "SignUpBean{" +
                "username='" + username + '\'' +
                ", idCard='" + idCard + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
