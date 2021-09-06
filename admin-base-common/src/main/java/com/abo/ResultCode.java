package com.abo;

import lombok.Getter;

/**
 * 返回结果枚举
 * @author abo
 */
@Getter
public enum  ResultCode {

    SUCCESS(200,"成功"),
    ERROR(400,"未知异常"),
    INVALID_USER_PASSWORD(401,"用户名或密码不正确");

    private int code;

    private String message;

    ResultCode(int code,String message){
        this.code=code;
        this.message=message;
    }



}
