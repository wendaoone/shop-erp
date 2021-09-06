package com.abo.security.adminsecurity.config;


import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.stereotype.*;

/**
 * JWT配置类
 * @Author youcong
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {
    /**
     * 密钥KEY
     */
    public  String secret;
    /**
     * TokenKey
     */
    public  String tokenHeader;
    /**
     * Token前缀字符
     */
    public  String tokenPrefix;
    /**
     * 过期时间
     */
    public  Integer expiration;






}