package com.xz.bootstarp;


import com.xz.deep.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


public class ConditionBootstrap {
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "ZJW")
    public String helloWorld() {
        return "hello world";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        context.close();
    }
}
