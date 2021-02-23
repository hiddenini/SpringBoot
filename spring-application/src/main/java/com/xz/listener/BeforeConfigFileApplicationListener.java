package com.xz.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

/**
 * Before {@link ConfigFileApplicationListener} 实现
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {


    @Override
    public int getOrder() {
        // 比 ConfigFileApplicationListener 优先级更高 那么无法读取到配置文件的内容
        //设置一个比ConfigFileApplicationListener 优先级低 就可以读取到
        //这也是为什么说springboot难以精通,因为拓展springboot需要了解内部的实现及其顺序
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = preparedEvent.getEnvironment();
            System.out.println("environment.getProperty(\"name\") : " + environment.getProperty("name"));
        }
        if (event instanceof ApplicationPreparedEvent) {
        }
    }
}
