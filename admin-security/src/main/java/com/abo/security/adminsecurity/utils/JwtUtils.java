package com.abo.security.adminsecurity.utils;


import com.abo.security.adminsecurity.config.JWTConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUtils {
    private static final String secretKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9"; //进行数字签名的私钥，一定要保管好，不能和我一样写到博客中。。。。。


    public static String acquireJWT(JWTConfig jwtConfig, UserDetails userDetails) {
        return "";
//
        //生成jwt令牌
//        JwtBuilder jwtBuilder = Jwts.builder()
//                .setId(userDetails)//设置jwt
//                .setSubject("shop-erp")//设置jwt主题
//                .setIssuedAt(new Date())//设置jwt签发日期
//                .setExpiration(date)//设置jwt的过期时间
//                .claim("userId", userDetails.get)
//                .signWith(SignatureAlgorithm.HS256, secretKey);
//        return jwtBuilder.compact();
    }

    /**
     * 解析JWT字符串
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
