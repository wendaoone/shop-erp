package com.abo.security.adminsecurity.handler;

import com.abo.Messages;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class AjaxAuthenticationHandler implements
        AuthenticationFailureHandler, AuthenticationSuccessHandler, AccessDeniedHandler {


    private void writeMessage(HttpServletResponse response,Messages<String> messages){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try(PrintWriter out = response.getWriter()) {
            out.append(JSONObject.toJSONString(messages));
        } catch (IOException e) {
            log.error("authentication write json error",e);
        }
    }



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)  {
        writeMessage(response,Messages.fail(exception.getMessage()));
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)  {
        writeMessage(response,Messages.success());
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        writeMessage(response,Messages.fail(accessDeniedException.getMessage()));
    }
}
