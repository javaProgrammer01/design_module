package com.ali.cq.controller;

import com.ali.cq.feign.DemoProviderOpenFeignAPI;
import com.ali.cq.service.ISentinelService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private DemoProviderOpenFeignAPI demoProviderOpenFeignAPI;

    @Autowired
    private ISentinelService sentinelService;

    @GetMapping("/getTest")
    public String getTest() {
        return demoProviderOpenFeignAPI.getAddr();
    }

    @GetMapping("/sentinel")
    @SentinelResource(value = "sentinel", blockHandler = "SentinelFallbackMethod")
    public String getTestSentinel() {
        return sentinelService.getTestSentinel();
    }

    //持久化配置
    @GetMapping("/config")
    @SentinelResource(value = "config", blockHandler = "SentinelFallbackMethod")
    public String sentinelConfig() {
        return sentinelService.getSentinelConfig();
    }

    @GetMapping("/config2")
    @SentinelResource(value = "config2", blockHandler = "SentinelFallbackMethod")
    public String sentinelConfig2() {
        return sentinelService.getSentinelConfig2();
    }

    /**
     * 返回限流规则提示
     *
     * @param e
     * @return
     */
    public String SentinelFallbackMethod(BlockException e) {
        String errMsg = null;
        if (e instanceof AuthorityException) {
            errMsg = "授权规则不通过";
        } else if (e instanceof DegradeException) {
            errMsg = "触发了降级规则";
        } else if (e instanceof ParamFlowException) {
            errMsg = "触发了热点参数降级规则";
        } else if (e instanceof FlowException) {
            errMsg = "触发了流控规则";
        } else if (e instanceof SystemBlockException) {
            errMsg = "触发了系统降级规则";
        } else {
            errMsg = "触发失败";
        }
        return errMsg;
    }
}
