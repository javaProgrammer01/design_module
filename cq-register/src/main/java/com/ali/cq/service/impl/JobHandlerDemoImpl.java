package com.ali.cq.service.impl;

import com.ali.cq.service.IJobHandlerDemo;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;

public class JobHandlerDemoImpl implements IJobHandlerDemo {

    @Override
    @XxlJob(value = "test")
    public ReturnT<String> test() {
        System.out.println(111);
        return ReturnT.SUCCESS;
    }
}
