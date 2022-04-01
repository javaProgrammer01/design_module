package com.ali.cq.manyifdemo.entity;

import com.ali.cq.manyifdemo.enums.MessageStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandResultModel {
    /**
     * 返回状态
     */
    private MessageStatusEnum messageStatusEnum;

    /**
     * 消息
     */
    private String msg;
}
