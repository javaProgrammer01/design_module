package com.ali.cq.config;

import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


public class DemoFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getPath().pathWithinApplication().value();

        String userName = exchange.getRequest().getQueryParams().getFirst("userName");
        if (StringUtils.isEmpty(userName)) {
            //终止请求，直接回应
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //值越小，优先级越高
        //int HIGHEST_PRECEDENCE = -2147483648;
        //int LOWEST_PRECEDENCE = 2147483647;
        return 1;
    }
}
