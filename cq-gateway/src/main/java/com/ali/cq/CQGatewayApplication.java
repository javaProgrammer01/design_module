package com.ali.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CQGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CQGatewayApplication.class);
    }

//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder){
//        RouteLocator build = builder.routes()
//                .route(r -> r.path("/register/**").uri("http://www.baidu.com"))
//                .build();
//        return build;
//    }
}
