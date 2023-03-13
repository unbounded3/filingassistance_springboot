package cn.edu.guet.filingassistance_springboot.bean;

import java.util.Date;
import java.util.Objects;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.bean
 * @ClassName: Role.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月03日 21:08:00
 */
public class Role{
    private String id;
    private String name;
    private String remark;
    private String createBy;
    private Date createTime;
    private String lastUpdateBy;
    private Date lastUpdateTime;
    private Byte delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name) && Objects.equals(remark, role.remark) && Objects.equals(createBy, role.createBy) && Objects.equals(createTime, role.createTime) && Objects.equals(lastUpdateBy, role.lastUpdateBy) && Objects.equals(lastUpdateTime, role.lastUpdateTime) && Objects.equals(delFlag, role.delFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, remark, createBy, createTime, lastUpdateBy, lastUpdateTime, delFlag);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", delFlag=" + delFlag +
                '}';
    }
}
