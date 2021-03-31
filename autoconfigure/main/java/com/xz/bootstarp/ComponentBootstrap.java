package com.xz.bootstarp;

import com.xz.deep.anno.FirstComponent;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@ComponentScan(basePackages = "com.xz.deep.anno")
public class ComponentBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ComponentBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        FirstComponent firstComponent = context.getBean("firstComponent", FirstComponent.class);
        System.out.println(firstComponent.toString());
    }
}
