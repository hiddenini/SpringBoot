package com.xz.deep.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过 @Configuration 3.0  @Bean方式将helloWorld bean注入到容器中
 */
@Configuration
public class HelloConfig {
    @Bean
    public String helloWorld() {
        return  "hello world 2021";
    }
}
