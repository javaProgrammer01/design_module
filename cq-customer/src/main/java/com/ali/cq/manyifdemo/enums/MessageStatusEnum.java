package com.ali.cq.manyifdemo.enums;

public enum MessageStatusEnum {
    SUCCESS(1, "成功"),
    FAIL(2, "失败");

    private Integer code;
    private String name;

    MessageStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
