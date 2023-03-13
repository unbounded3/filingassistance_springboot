package cn.edu.guet.filingassistance_springboot.bean;

import java.util.Date;
import java.util.Objects;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.bean
 * @ClassName: UserRole.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月03日 21:18:00
 */
public class UserRole {
    private String id;
    private String userId;
    private String roleId;
    private String createBy;
    private Date createTime;
    private String lastUpdateBy;
    private Date lastUpdateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(id, userRole.id) && Objects.equals(userId, userRole.userId) && Objects.equals(roleId, userRole.roleId) && Objects.equals(createBy, userRole.createBy) && Objects.equals(createTime, userRole.createTime) && Objects.equals(lastUpdateBy, userRole.lastUpdateBy) && Objects.equals(lastUpdateTime, userRole.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId, createBy, createTime, lastUpdateBy, lastUpdateTime);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
