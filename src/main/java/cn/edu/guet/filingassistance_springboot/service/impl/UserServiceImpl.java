package cn.edu.guet.filingassistance_springboot.service.impl;

import cn.edu.guet.filingassistance_springboot.bean.Menu;
import cn.edu.guet.filingassistance_springboot.bean.Role;
import cn.edu.guet.filingassistance_springboot.bean.User;
import cn.edu.guet.filingassistance_springboot.bean.UserRole;
import cn.edu.guet.filingassistance_springboot.mapper.RoleMapper;
import cn.edu.guet.filingassistance_springboot.mapper.UserMapper;
import cn.edu.guet.filingassistance_springboot.mapper.UserRoleMapper;
import cn.edu.guet.filingassistance_springboot.service.MenuService;
import cn.edu.guet.filingassistance_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private MenuService menuService;

    @Override
    public User findByName(String name) {
        User sysUser = userMapper.findByName(name);
        if (sysUser != null) {
            List<UserRole> userRoles = findUserRoles(sysUser.getUserId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRoleNames(userRoles));
            return sysUser;
        }
        return null;
    }

    private String getRoleNames(List<UserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<UserRole> iter = userRoles.iterator(); iter.hasNext(); ) {
            UserRole userRole = iter.next();
            Role sysRole = roleMapper.selectByPrimaryKey(userRole.getRoleId());
            if (sysRole == null) {
                continue;
            }
            sb.append(sysRole.getRemark());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public List<UserRole> findUserRoles(String userId) {
        return userRoleMapper.findUserRoles(userId);
    }

    @Override
    public User findByIdCard(String idCard) {
        return userMapper.findByIdCard(idCard);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        System.out.println("获取用户权限菜单: "+userName);
        Set<String> perms = new HashSet<>();
        List<Menu> sysMenus = menuService.findByUser(userName);
        for (Menu sysMenu : sysMenus) {
            if (sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }
}
