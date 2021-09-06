package com.abo.adminauthor.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户基础信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @GetMapping("getBaseUserInfo")
    public String getBaseUserInfo(@RequestParam(value = "userId", required = false) Long userId) {

        return "" + userId;
    }

}
