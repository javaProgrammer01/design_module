package com.ali.cq.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@RestController
public class CQRegisterController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping({"/getAddr"})
    public String getAddr() {
        return (String) this.restTemplate.getForObject("http://192.168.157.111:8848/nacos/v1/cs/configs?dataId=addr&group=DEFAULT_GROUP", String.class, new Object[0]);
    }

    @GetMapping({"/getAddr2"})
    public String getAddr2() throws NacosException {
        Properties properties = new Properties();
        properties.put("serverAddr", "192.168.157.111:8848");
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig("addr-test", "DEFAULT_GROUP", 5000L);
        return content;
    }
}
