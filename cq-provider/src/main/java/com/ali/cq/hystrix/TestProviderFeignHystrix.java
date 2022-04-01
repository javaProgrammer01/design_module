package com.ali.cq.hystrix;

import com.ali.cq.feign.DemoProviderOpenFeignAPI;
import org.springframework.stereotype.Component;

@Component
public class TestProviderFeignHystrix implements DemoProviderOpenFeignAPI {

    @Override
    public String getAddr() {
        return null;
    }

}
