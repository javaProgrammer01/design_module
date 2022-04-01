package com.ali.message.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestProducerController {

    private final Source source;

    @GetMapping("/test-stream")
    public String testStream(){
        Message<String> message = MessageBuilder
                .withPayload("消息体")
                .build();
        source.output().send(message);
        return "send message success!";
    }
}
