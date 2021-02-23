package com.xz.deep.anno;

import com.xz.deep.conf.HelloConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * 激活 HelloWorld 模块
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloConfig.class)
//@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
