package cn.edu.guet.filingassistance_springboot.config;

import cn.edu.guet.filingassistance_springboot.security.JwtAuthenticationFilter;
import cn.edu.guet.filingassistance_springboot.security.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * @ProjectName: filingassistance_springboot
 * @PackageName: cn.edu.guet.filingassistance_springboot.config
 * @ClassName: SecurityConfig.java
 * @author: PangJiaEn
 * @version: 1.0.0
 * @createTime: 2023年03月02日 19:59:00
 */

/**
 * Security的自定义配置
 * 1、设置身份验证组件
 * 2、配置HTTP的访问规则
 * 3、注册AuthenticationManager实现类到Spring的IoC容器，以便过滤器可以注入该实例
 */
@Configuration
@EnableWebSecurity//启用SpringSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启全局方法安全，当访问某个路径时会检查是否具有权限
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    /*
    自定义身份验证组件
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
    }

    /*
    配置访问规则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用CSRF攻击（因为用的是token，默认基于cookie）
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/").permitAll()//首页
                .antMatchers("/login").permitAll()//登录页面
                // 其他所有请求都需要身份认证
                .anyRequest().authenticated();
        http.headers().frameOptions().disable();
        // 退出登录处理器
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        //在过滤器链中UsernamePasswordAuthenticationFilter的前面加上自己定义的过滤器
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
