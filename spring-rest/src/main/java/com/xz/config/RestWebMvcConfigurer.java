package com.xz.config;

import com.xz.http.converter.properties.PropertiesHttpMessageConverter;
import com.xz.support.PropertiesHandlerMethodArgumentResolver;
import com.xz.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest{@link WebMvcConfigurer}实现
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init() {
        List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        ArrayList<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(resolvers.size() + 1);
        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        //添加已经注册过的对象
        newResolvers.addAll(resolvers);
        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);


        // 获取当前 HandlerMethodReturnValueHandler 所有的 Handler 对象
        List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(handlers.size() + 1);
        // 添加 PropertiesHandlerMethodReturnValueHandler 到集合首位
        newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        // 添加 已注册的 Handler 对象集合
        newHandlers.addAll(handlers);
        // 重新设置 Handler 对象集合
        requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);

    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //添加PropertiesHandlerMethodArgumentResolver到首位
        /**
         * 这样添加的自定义的HandlerMethodArgumentResolver时,优先级低于内置的HandlerMethodArgumentResolver
         *
         */
        //resolvers.add(0, new PropertiesHandlerMethodArgumentResolver());


    }

    /**
     * 添加跨域的配置
     */
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }



    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到converters的末尾,这样在处理返回值的媒体类型时时排不到PropertiesHttpMessageConverter的,位置太靠后

        //converters.add(new PropertiesHttpMessageConverter());

        converters.add(0, new PropertiesHttpMessageConverter());
    }
}
