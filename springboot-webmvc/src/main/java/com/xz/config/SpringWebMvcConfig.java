package com.xz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该项目需要打成war包，在dos下启动。在idea下访问不到jsp文件
 * springboot时代大大简化了mvc的配置
 * WebMvcAutoConfiguration 替换了 @EnableWebMvc
 * DispatcherServletAutoConfiguration 替换了  DispatcherServlet
 * ServletWebServerFactoryAutoConfiguration 配置了 Servlet 容器
 * <p>
 * 在使用springboot时，如果想要使用其对于mvc的自动装配,例如使用配置文件中的前缀后缀
 * 那么需要去掉@EnableWebMvc这个注解，因为在WebMvcAutoConfiguration中使用了
 *
 * @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)这个注解 说明在容器中存在WebMvcConfigurationSupport.class这个类时不启动自动装配，而这个类在
 * @EnableWebMvc注解中被注入到了容器中
 */

@Configuration
//@EnableWebMvc
public class SpringWebMvcConfig implements WebMvcConfigurer {
/*    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截中...");
                return true;
            }
        });
    }
}
