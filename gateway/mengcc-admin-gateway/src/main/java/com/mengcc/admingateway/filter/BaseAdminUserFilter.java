package com.mengcc.admingateway.filter;

import com.mengcc.admingateway.config.MengccConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;

/**
 * @author zhouzq
 * @date 2019/11/9
 * @desc 后台用户拦截器
 */
@Slf4j
@Component
public class BaseAdminUserFilter implements GlobalFilter, Ordered {

    /**
     * 过滤器要忽略的http请求方法
     */
    private static final HttpMethod[] ALLOWED_METHODS = {HttpMethod.OPTIONS, HttpMethod.HEAD, HttpMethod.TRACE};


    @Autowired
    private MengccConfigProperties mengccConfigProperties;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();


//        if (Arrays.stream(ALLOWED_METHODS).anyMatch(httpMethod -> httpMethod.matches())) {
//            return null;
//        }

        URI requestURI = request.getURI();

        String path = requestURI.getPath();
        //判断是否在白名单里面
        log.info(">>>> base admin user filter >>>");


        //校验token

        //校验IP白名单

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 判断是否需要登录token
     * @param path
     * @return
     */
    private boolean isOpenUrl(String path) {
        return mengccConfigProperties.getOpenUrls().stream().anyMatch(path::equals);
    }

    /**
     * 判断是否需要校验权限
     * @param path
     * @return
     */
    public boolean isPublicUrl(String path) {
        return mengccConfigProperties.getPubilcUrls().stream().anyMatch(path::equals);
    }
}
