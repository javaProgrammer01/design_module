package com.ali.cq.manyifdemo.service;

import com.ali.cq.manyifdemo.entity.HandResultModel;
import com.ali.cq.manyifdemo.entity.MessageInfo;

/**
 * @author Administrator
 */
public interface IMessageService {
    /**
     * 公共处理接口
     *
     * @param messageInfo
     */
    HandResultModel handleMessage(MessageInfo messageInfo);
}
