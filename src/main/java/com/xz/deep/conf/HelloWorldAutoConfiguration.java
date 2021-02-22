package com.xz.deep.conf;

import com.xz.deep.anno.EnableHelloWorld;
import com.xz.deep.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHelloWorld
@ConditionalOnSystemProperty(name="user.name",value = "ZJW")
public class HelloWorldAutoConfiguration {
}
