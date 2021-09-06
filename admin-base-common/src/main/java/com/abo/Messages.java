package com.abo;

import lombok.Data;

@Data
public class Messages<T> {

    /**
     * 返回数据
     */
    private T data;

    /**
     * 编码
     */
    private Integer code;

    /**
     *
     */
    private String message;


    public static Messages success() {
        Messages<String> messages = new Messages<>();
        messages.setCode(ResultCode.SUCCESS.getCode());
        messages.setMessage(ResultCode.SUCCESS.getMessage());
        return messages;
    }

    public static <T> Messages success(T data) {
        Messages<T> messages = success();
        messages.setData(data);
        return messages;
    }

    public static Messages fail() {
        return fail(ResultCode.ERROR.getMessage());
    }

    public static Messages fail(String data) {
        Messages<String> messages = new Messages<>();
        messages.setCode(ResultCode.ERROR.getCode());
        messages.setMessage(data);
        return messages;
    }


}
