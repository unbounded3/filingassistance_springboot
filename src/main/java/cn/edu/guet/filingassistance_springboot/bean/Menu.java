package cn.edu.guet.filingassistance_springboot.bean;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.bean
 * @ClassName: Menu.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月03日 21:05:00
 */
public class Menu {
    private String id;
    private String parentId;
    private String name;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;
    private String createBy;
    private Date createTime;
    private String lastUpdateBy;
    private Date lastUpdateTime;
    private Byte delFlag;

    // 非数据库字段
    private String parentName;
    // 非数据库字段
    private Integer level;
    // 非数据库字段
    private List<Menu> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(parentId, menu.parentId) && Objects.equals(name, menu.name) && Objects.equals(url, menu.url) && Objects.equals(perms, menu.perms) && Objects.equals(type, menu.type) && Objects.equals(icon, menu.icon) && Objects.equals(orderNum, menu.orderNum) && Objects.equals(createBy, menu.createBy) && Objects.equals(createTime, menu.createTime) && Objects.equals(lastUpdateBy, menu.lastUpdateBy) && Objects.equals(lastUpdateTime, menu.lastUpdateTime) && Objects.equals(delFlag, menu.delFlag) && Objects.equals(parentName, menu.parentName) && Objects.equals(level, menu.level) && Objects.equals(children, menu.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, name, url, perms, type, icon, orderNum, createBy, createTime, lastUpdateBy, lastUpdateTime, delFlag, parentName, level, children);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", orderNum=" + orderNum +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", delFlag=" + delFlag +
                ", parentName='" + parentName + '\'' +
                ", level=" + level +
                ", children=" + children +
                '}';
    }
}
