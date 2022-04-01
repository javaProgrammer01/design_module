package com.ali.cq.controller;

import com.ali.cq.manyifdemo.entity.HandResultModel;
import com.ali.cq.manyifdemo.entity.MessageInfo;
import com.ali.cq.manyifdemo.enums.MsgTypeEnum;
import com.ali.cq.manyifdemo.service.IMessageService;
import com.ali.cq.manyifdemo.service.springservice.MessageServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCustomerController {

    @Autowired
    private MessageServiceContext messageServiceContext;

    @GetMapping("/toDealMessageByType")
    public HandResultModel toDealMessageByType() {
        MessageInfo messageInfo = new MessageInfo(MsgTypeEnum.TEXT.code, "消息内容");
        //根据不同类型，从spring容器中获取对应处理类
        IMessageService messageService = messageServiceContext.getMessageService(messageInfo.getType());
        return messageService.handleMessage(messageInfo);
    }
}
