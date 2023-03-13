package cn.edu.guet.filingassistance_springboot.controller;

import cn.edu.guet.filingassistance_springboot.bean.LoginBean;
import cn.edu.guet.filingassistance_springboot.bean.User;
import cn.edu.guet.filingassistance_springboot.http.HttpResult;
import cn.edu.guet.filingassistance_springboot.security.JwtAuthenticationToken;
import cn.edu.guet.filingassistance_springboot.service.UserService;
import cn.edu.guet.filingassistance_springboot.util.PasswordUtils;
import cn.edu.guet.filingassistance_springboot.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.controller
 * @ClassName: LoginController.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月02日 14:21:00
 */

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("login")
//    public HttpResult login(String username,String password, HttpServletRequest request){//接收表单形式
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request){
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        // 用户信息

        System.out.println(username);
        System.out.println(password);
        User user = userService.findByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }

        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);


    }
}
