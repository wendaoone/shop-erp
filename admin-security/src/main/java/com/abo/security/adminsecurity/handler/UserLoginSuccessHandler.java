package com.abo.security.adminsecurity.handler;


import com.abo.security.adminsecurity.config.JWTConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录成功处理类
 * @Author youcong
 */
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {


    /**
     * 登录成功返回结果
     * @Author youcong
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        // 组装JWT
//        SelfUserEntity selfUserEntity =  (SelfUserEntity) authentication.getPrincipal();
        String token = "abcdefg";  //todo token 生成
        token = JWTConfig.tokenPrefix + token;

        // 封装返回参数
        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code","200");
        resultData.put("msg", "登录成功");
        resultData.put("token",token);
//        ResultUtil.responseJson(response,resultData);
    }
}