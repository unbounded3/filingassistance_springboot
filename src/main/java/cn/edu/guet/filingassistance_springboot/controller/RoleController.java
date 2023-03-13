package cn.edu.guet.filingassistance_springboot.controller;

import cn.edu.guet.filingassistance_springboot.http.HttpResult;
import cn.edu.guet.filingassistance_springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制器
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAuthority('sys:role:view')")//权限注解，只有具有“sys:role:view”权限的用户才能访问该接口
    @GetMapping(value = "/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(roleService.findAll());
    }
}
