package com.mengcc.admingateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @author zhouzq
 * @date 2019/11/9
 * @desc 后台用户拦截器
 */
@Slf4j
@Component
public class BaseAdminUserFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
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
}
