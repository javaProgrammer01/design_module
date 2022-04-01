package com.ali.cq.controller;

import com.ali.cq.entity.User;
import com.ali.cq.manyifdemo.entity.MessageInfo;
import com.ali.cq.manyifdemo.enums.MsgTypeEnum;
import com.ali.cq.manyifdemo.service.IMessageService;
import com.ali.cq.manyifdemo.service.springservice.MessageServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestCustomerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getCustomerName")
    public String getAddr() {
        return "customerName";
    }

    @GetMapping("/restTemplate1")
    public String getRestTemplate1() {
        String forObject = this.restTemplate.getForObject("http://localhost:9004/provider/getTest", String.class);
        return forObject;
    }

    @PostMapping("/restTemplate2")
    @ResponseBody
    public String getRestTemplate2(@RequestBody User user) {
        //this.restTemplate.postForObject("http://localhost:9004/provider/getTest", User.class);
        return "";
    }


    @Autowired
    private MessageServiceContext messageServiceContext;


    @GetMapping("/hi")
    public String test1() {
        MessageInfo messageInfo = new MessageInfo(MsgTypeEnum.TEXT.code, "消息内容");
        IMessageService messageService = messageServiceContext.getMessageService(messageInfo.getType());
        messageService.handleMessage(messageInfo);
        return "1";
    }
}
