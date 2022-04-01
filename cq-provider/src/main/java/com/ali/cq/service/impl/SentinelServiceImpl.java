package com.ali.cq.service.impl;

import com.ali.cq.service.ISentinelService;
import org.springframework.stereotype.Service;

@Service
public class SentinelServiceImpl implements ISentinelService {
    @Override
    public String getTestSentinel() {
        return "叫爸爸!";
    }

    @Override
    public String getSentinelConfig() {
        return "叫爷爷";
    }

    @Override
    public String getSentinelConfig2() {
        return "叫奶奶";
    }
}
