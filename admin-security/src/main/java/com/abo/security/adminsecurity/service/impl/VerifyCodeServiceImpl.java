package com.abo.security.adminsecurity.service.impl;

import com.abo.security.adminsecurity.service.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

@Slf4j
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {


    @Override
    public void checkVerifyCode(String verifyCodeParameterKey, String verifyCode) {
        log.info("verify code for user password login");
    }
}
