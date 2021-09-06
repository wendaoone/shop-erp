package com.abo.adminauthor.demo.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 测试gateway filter
 * <p>
 * AddRequestHeader/AddRequestParameter/AddResponseHeader
 * <p>
 * DedupeResponseHeader
 * <p>
 * CircuitBreaker/FallbackHeaders  断路器以及短路异常处理
 * <p>
 * MapRequestHeader  有fegin时候使用 可以将请求中的header信息转移到fegin中(需要验证)
 * <p>
 * PrefixPath 给请求统一增加前缀 如本项目中的/admin 就是从网关中统一添加的，通过 http://localhost/demo/testAddHeaderAndParameter即可访问
 * PreserveHostHeader 保留客户端ip地址，默认为网关的ip地址
 * RequestRateLimiter
 * RemoveRequestHeader 删除头部信息中指定值
 * RemoveRequestParameter 删除指定的请求参数
 * RewritePath
 * RewriteLocationResponseHeader
 * RewriteResponseHeader
 * SaveSession
 * SetPath
 * <p>
 * AddRequestHeader/AddRequestParameter/AddResponseHeader
 * RemoveRequestHeader/RemoveRequestParameter/RemoveResponseHeader
 * MapRequestHeader 将指定的参数映射为其他参数
 */
@RestController
@RequestMapping("/demo")
public class DemoGateWayController {


    /**
     * 测试AddRequestHeader/AddRequestParameter/AddResponseHeader/MapRequestHeader
     * /PreserveHostHeader/PrefixPath/RemoveRequestHeader/RemoveRequestParameter/RemoveResponseHeader效果
     *
     * @return
     */
    @GetMapping("testAddHeaderAndParameter")
    public Map<String, Object> testAddHeaderAndParameter(HttpServletRequest request) {
        Cookie[] cookies = Optional.ofNullable(request.getCookies()).orElse(new Cookie[0]);
        Map<String, String> cookieMap = new HashMap<>();
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie.getValue());
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headerMap = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headerMap.put(headerName, request.getHeader(headerName));
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cookies", cookieMap);
        resultMap.put("header", headerMap);
        resultMap.put("params", request.getParameterMap());
        return resultMap;
    }
}
