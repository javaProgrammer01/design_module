package com.ali.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Sink.class)
public class CQMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(CQMessageApplication.class);
    }
}
