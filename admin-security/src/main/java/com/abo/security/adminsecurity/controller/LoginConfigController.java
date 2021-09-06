package com.abo.security.adminsecurity.controller;

import com.abo.Messages;
import com.abo.security.adminsecurity.vo.ConfigVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginConfigController {

    @GetMapping("admin/config")
    public Messages<ConfigVo> getConfig() {

        return Messages.success(new ConfigVo());

    }

}
