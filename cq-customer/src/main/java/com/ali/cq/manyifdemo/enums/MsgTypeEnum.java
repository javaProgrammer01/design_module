package com.ali.cq.manyifdemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MsgTypeEnum {
    TEXT(1, "文本"),
    IMAGE(2, "图片"),
    VIDEO(3, "视频");
    public Integer code;
    public String name;
}
