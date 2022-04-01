package com.ali.cq.manyifdemo.service.handle;


import com.ali.cq.manyifdemo.entity.HandResultModel;
import com.ali.cq.manyifdemo.entity.MessageInfo;
import com.ali.cq.manyifdemo.enums.MessageStatusEnum;
import com.ali.cq.manyifdemo.service.IMessageService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 */
@Slf4j
public abstract class MessageServiceFactory implements IMessageService {

    @Override
    public HandResultModel handleMessage(MessageInfo messageInfo) {
        HandResultModel handResultModel = new HandResultModel();
        handResultModel.setMessageStatusEnum(MessageStatusEnum.SUCCESS);

        try {
            this.toDealMsgHandle(messageInfo);
        } catch (Exception e) {
            log.error("业务处理参数:{},异常:{}", JSON.toJSONString(messageInfo), JSON.toJSONString(e));
            handResultModel.setMessageStatusEnum(MessageStatusEnum.FAIL);
            handResultModel.setMsg(JSON.toJSONString(e.getMessage()));
        }

        return handResultModel;
    }

    abstract void toDealMsgHandle(MessageInfo messageInfo);
}
