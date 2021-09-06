package com.abo.security.adminsecurity.filter;

import com.abo.security.adminsecurity.handler.AjaxAuthenticationHandler;
import com.abo.security.adminsecurity.service.VerifyCodeService;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该方法为用户名密码的增强版本实现，当用户输错密码两次，自动转化为验证码
 * 通过该方式登陆，会优先校验请求是否已经触发验证码校验，如果没有触发验证码校验，
 * 则直接采用父类做用户名密码登陆逻辑，
 * 否则校验验证码，当验证码通过校验才使用父类做用户名密码校验
 *
 * @author abo
 */
public class UsernamePasswordEnhanceAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SPRING_SECURITY_FORM_VERIFY_CODE_KEY = "code";

    public static final String SPRING_SECURITY_FORM_VERIFY_CODE_PARAMETER_KEY = "verifyCode";

    private String verifyCodeParameter = SPRING_SECURITY_FORM_VERIFY_CODE_KEY;

    private String verifyCodeParameterKey = SPRING_SECURITY_FORM_VERIFY_CODE_PARAMETER_KEY;

    private static final AntPathRequestMatcher defaultMatcher = new AntPathRequestMatcher("/admin/login");


    private VerifyCodeService verifyCodeService;

    public void setVerifyCodeService(VerifyCodeService verifyCodeService) {
        this.verifyCodeService = verifyCodeService;
    }

    public UsernamePasswordEnhanceAuthenticationFilter() {
        setRequiresAuthenticationRequestMatcher(defaultMatcher);
        setAuthenticationFailureHandler(new AjaxAuthenticationHandler());
        setAuthenticationSuccessHandler(new AjaxAuthenticationHandler());
    }

    @Nullable
    protected String obtainVerifyCode(HttpServletRequest request) {
        return request.getParameter(verifyCodeParameter);
    }

    @Nullable
    protected String obtainVerifyCodeKey(HttpServletRequest request) {
        return request.getHeader(verifyCodeParameterKey);
    }

    public void setVerifyCodeParameter(String verifyCodeParameter) {
        Assert.hasLength(verifyCodeParameter, "账号密码登陆验证码参数不能为空！");
        this.verifyCodeParameter = verifyCodeParameter;
    }

    public void setVerifyCodeParameterKey(String verifyCodeParameterKey) {
        Assert.hasLength(verifyCodeParameterKey, "账号密码登陆验证码参数名不能为空！");
        this.verifyCodeParameterKey = verifyCodeParameterKey;
    }


    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String verifyCode = obtainVerifyCode(request);
        String verifyCodeParameterKey = obtainVerifyCodeKey(request);
        verifyCodeService.checkVerifyCode(verifyCodeParameterKey, verifyCode);
        return super.attemptAuthentication(request, response);
    }

}
