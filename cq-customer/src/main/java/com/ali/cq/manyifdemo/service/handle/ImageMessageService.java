package com.ali.cq.manyifdemo.service.handle;

import com.ali.cq.manyifdemo.annotation.MsgTypeAnnotation;
import com.ali.cq.manyifdemo.entity.MessageInfo;
import com.ali.cq.manyifdemo.enums.MsgTypeEnum;
import org.springframework.stereotype.Service;

@Service
@MsgTypeAnnotation(value = MsgTypeEnum.IMAGE)
public class ImageMessageService extends MessageServiceFactory {

    @Override
    void toDealMsgHandle(MessageInfo messageInfo) {
        System.out.println("图片");
    }
}
