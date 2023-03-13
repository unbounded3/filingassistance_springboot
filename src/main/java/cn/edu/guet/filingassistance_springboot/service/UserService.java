package cn.edu.guet.filingassistance_springboot.service;


import cn.edu.guet.filingassistance_springboot.bean.User;
import cn.edu.guet.filingassistance_springboot.bean.UserRole;

import java.util.List;
import java.util.Set;

/**
 * 用户管理
 *
 */
public interface UserService {

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    User findByName(String username);

    List<UserRole> findUserRoles(String userId);

    User findByIdCard(String idCard);
}
