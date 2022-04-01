package com.ali.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
