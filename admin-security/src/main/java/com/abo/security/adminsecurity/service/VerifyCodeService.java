package com.abo.security.adminsecurity.service;

public interface VerifyCodeService {
    void checkVerifyCode(String verifyCodeParameterKey, String verifyCode);
}
