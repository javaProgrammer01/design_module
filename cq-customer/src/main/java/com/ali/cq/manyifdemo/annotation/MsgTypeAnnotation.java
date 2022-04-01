package com.ali.cq.manyifdemo.annotation;

import com.ali.cq.manyifdemo.enums.MsgTypeEnum;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MsgTypeAnnotation {
    MsgTypeEnum value();
}
