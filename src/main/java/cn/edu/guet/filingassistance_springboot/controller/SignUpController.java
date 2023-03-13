package cn.edu.guet.filingassistance_springboot.controller;

import cn.edu.guet.filingassistance_springboot.bean.SignUpBean;
import cn.edu.guet.filingassistance_springboot.http.HttpResult;
import cn.edu.guet.filingassistance_springboot.service.UserService;
import cn.edu.guet.filingassistance_springboot.util.IdCardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.controller
 * @ClassName: SignUpController.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月12日 17:18:00
 */
@RestController
public class SignUpController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public HttpResult signUp(@RequestBody SignUpBean signUpBean, HttpServletRequest request){

        String idCard = signUpBean.getIdCard();
        if (IdCardUtil.isValidCard(idCard)) {
            if (userService.findByIdCard(idCard) == null){
                String username = signUpBean.getUsername();
                String password = signUpBean.getPassword();
            }else{
                return HttpResult.error("该身份证已经注册过，请直接登录！");
            }
        }else{
            return HttpResult.error("无效的身份证");
        }
        return null;
    }
}
