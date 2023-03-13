package cn.edu.guet.filingassistance_springboot.service.impl;

import cn.edu.guet.filingassistance_springboot.bean.Menu;
import cn.edu.guet.filingassistance_springboot.mapper.MenuMapper;
import cn.edu.guet.filingassistance_springboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper sysMenuMapper;

    @Override
    public List<Menu> findByUser(String userName) {
        if (userName == null || "".equals(userName) || "admin".equalsIgnoreCase(userName)) {
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findByUserName(userName);
    }

    @Override
    public List<Menu> findTree(String userName, int menuType) {
        List<Menu> sysMenus = new ArrayList<>();
        List<Menu> menus = findByUser(userName);//找到该用户能使用的菜单
        for (Menu menu : menus) {
            if (menu.getParentId() == null || "0".equals(menu.getParentId())) {
                menu.setLevel(0);//父菜单
                if (!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    private void findChildren(List<Menu> SysMenus, List<Menu> menus, int menuType) {
        for (Menu SysMenu : SysMenus) {
            List<Menu> children = new ArrayList<>();
            for (Menu menu : menus) {
                if (menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }

                if (SysMenu.getId() != null && SysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(SysMenu.getName());
                    menu.setLevel(SysMenu.getLevel() + 1);
                    if (!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            SysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<Menu> sysMenus, Menu sysMenu) {
        boolean exist = false;
        for (Menu menu : sysMenus) {
            if (menu.getId().equals(sysMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }
}
