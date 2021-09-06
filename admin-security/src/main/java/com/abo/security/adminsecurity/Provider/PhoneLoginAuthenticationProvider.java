package com.abo.security.adminsecurity.Provider;

import com.abo.security.adminsecurity.Provider.auth.PhoneAbstractAuthenticationToken;
import com.abo.security.adminsecurity.service.login.PhoneUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 手机验证码登陆
 */
@Component
public class PhoneLoginAuthenticationProvider implements AuthenticationProvider {

    @Resource
    @Qualifier("PhoneUserService")
    private PhoneUserService phoneUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails user = phoneUserService.loadUserByUsername(username);
        String sms = "123";
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new PhoneAbstractAuthenticationToken(user, sms, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PhoneAbstractAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
