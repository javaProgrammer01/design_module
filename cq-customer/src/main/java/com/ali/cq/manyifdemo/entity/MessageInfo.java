package com.ali.cq.manyifdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageInfo {
    // 消息类型
    private Integer type;
    // 消息内容
    private String content;
}
