package cn.edu.guet.filingassistance_springboot.service;


import cn.edu.guet.filingassistance_springboot.bean.Role;

import java.util.List;


/**
 * 角色管理
 */
public interface RoleService {

    /**
     * 查询全部
     *
     * @return
     */
    List<Role> findAll();

}
