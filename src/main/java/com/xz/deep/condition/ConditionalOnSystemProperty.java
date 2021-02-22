package com.xz.deep.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/***
 * java 系统属性 条件属性
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional({OnSystemPropertyCondition.class})
public @interface ConditionalOnSystemProperty {

    //系统属性名称
    String name();

    //系统属性值
    String value();
}