package com.xz.deep.selector;

import com.xz.deep.conf.HelloConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * {@link ImportSelector 3.1}
 * 通过ImportSelector 将helloWorld bean注入到容器中更灵活
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /**
         * 这里可以有各种逻辑
         */
        return new String[]{HelloConfig.class.getName()};
    }
}
