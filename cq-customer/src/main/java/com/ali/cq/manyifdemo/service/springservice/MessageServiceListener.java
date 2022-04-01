package com.ali.cq.manyifdemo.service.springservice;

import com.ali.cq.manyifdemo.annotation.MsgTypeAnnotation;
import com.ali.cq.manyifdemo.service.IMessageService;
import com.ali.cq.manyifdemo.service.springservice.MessageServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageServiceListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MessageServiceContext messageServiceContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(MsgTypeAnnotation.class);
        beans.forEach((name, bean) -> {
            MsgTypeAnnotation typeHandler = bean.getClass().getAnnotation(MsgTypeAnnotation.class);
            messageServiceContext.putMessageService(typeHandler.value().code, (IMessageService) bean);
        });
    }
}
