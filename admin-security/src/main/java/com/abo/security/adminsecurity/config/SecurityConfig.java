package com.abo.security.adminsecurity.config;

import com.abo.security.adminsecurity.filter.UsernamePasswordEnhanceAuthenticationFilter;
import com.abo.security.adminsecurity.handler.AjaxAuthenticationHandler;
import com.abo.security.adminsecurity.service.VerifyCodeService;
import com.abo.security.adminsecurity.service.login.DefaultUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * SpringSecurity配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启权限注解,默认是关闭的
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private VerifyCodeService verifyCodeService;

    @Resource
    private DefaultUserService defaultUserService;

    @Resource
    private List<AuthenticationProvider> authenticationProviderList;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UsernamePasswordEnhanceAuthenticationFilter usernamePasswordEnhanceAuthenticationFilter() throws Exception {
        UsernamePasswordEnhanceAuthenticationFilter filter = new UsernamePasswordEnhanceAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setVerifyCodeService(verifyCodeService);
        return filter;
    }

    private void authenticationProvider(HttpSecurity http) {
        for (AuthenticationProvider authenticationProvider : authenticationProviderList) {
            http.authenticationProvider(authenticationProvider);
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(defaultUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        authenticationProvider(http);
        http.addFilterBefore(usernamePasswordEnhanceAuthenticationFilter(), UsernamePasswordEnhanceAuthenticationFilter.class);
        http.exceptionHandling().accessDeniedHandler(new AjaxAuthenticationHandler());
//        http.csrf().disable();
        http.authorizeRequests().antMatchers("/admin/config").permitAll();
        http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository());

    }
}