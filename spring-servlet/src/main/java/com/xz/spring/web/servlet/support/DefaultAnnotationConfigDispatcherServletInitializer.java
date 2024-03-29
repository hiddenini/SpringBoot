package com.xz.spring.web.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 * 替代了web.xml文件
 */
@ComponentScan(basePackages = "com.xz.spring.web.servlet.controller")
@Configuration
public class DefaultAnnotationConfigDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // DispatcherServlet
        return new Class[]{getClass()};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
