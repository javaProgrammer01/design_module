package com.ali.cq.feign;

import com.ali.cq.hystrix.TestProviderFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cq-customer", fallback = TestProviderFeignHystrix.class)
public interface DemoProviderOpenFeignAPI {
    @GetMapping("/getCustomerName")
    String getAddr();
}
