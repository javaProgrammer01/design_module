package com.ali.cq.manyifdemo.service.springservice;

import com.ali.cq.manyifdemo.service.IMessageService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class MessageServiceContext {
    private final Map<Integer, IMessageService> handlerMap = new HashMap<>();

    public IMessageService getMessageService(Integer type) {
        return handlerMap.get(type);
    }

    public void putMessageService(Integer code, IMessageService messageService) {
        handlerMap.put(code, messageService);
    }
}
