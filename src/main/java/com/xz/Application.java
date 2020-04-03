package com.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xz
 * @date 2020/2/13 20:55
 **/

@SpringBootApplication
//@EnableConfigurationProperties(HuMan.class)
/**
 * EnableConfigurationProperties  将括号内的类(HuMan.class)注册到spring容器中,也可以直接在HuMan.class添加@Component注解
 *
 * 这个注解广泛用于springBoot的自动配置之中
 *
 *
 * springBoot的自动配置原理简单来说:
 *
 * @SpringBootApplication中的@EnableAutoConfiguration的@Import(AutoConfigurationImportSelector.class)
 *
 * 其中AutoConfigurationImportSelector中会调用方法通过SpringFactoriesLoader.loadFactoryNames()扫描所有具有META-INF/spring.factories的jar包。
 *
 * 找到spring.factories配置文件中的所有自动配置类，并对其进行加载，而这些自动配置类都是以AutoConfiguration结尾来命名的
 *
 * 它实际上就是一个JavaConfig形式的Spring容器配置类，它能通过以Properties结尾命名的类中取得在全局配置文件中配置的属性
 *
 * 并将这些类配置到spring容器中(那些自身满足了各种condition的bean)
 *
 * spring-boot-autoconfigure-x.x.x.x.jar中一般都有一个这样的spring.factories文件
 *
 * 在整个spring容器被初始化的时候会调用到AutoConfigurationImportSelector中的selectImports方法,具体是在applicationde refreshf方法中的invokeBeanFactoryPostProcessors这一步去解析的import
 *
 *
 */
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
