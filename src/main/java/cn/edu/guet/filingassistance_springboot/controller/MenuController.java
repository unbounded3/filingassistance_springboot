package cn.edu.guet.filingassistance_springboot.controller;

import cn.edu.guet.filingassistance_springboot.bean.Menu;
import cn.edu.guet.filingassistance_springboot.http.HttpResult;
import cn.edu.guet.filingassistance_springboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单控制器
 *
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping (value = "/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        System.out.println("查找菜单树：" + userName);
        List<Menu> sysMenus = menuService.findTree(userName, 1);
        return HttpResult.ok(sysMenus);
    }
}
