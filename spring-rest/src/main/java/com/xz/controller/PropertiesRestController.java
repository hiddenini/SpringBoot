package com.xz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * {@link Properties} {@link RestController}
 *
 * @author 小马哥
 * @since 2018/5/27
 */

@RestController
public class PropertiesRestController {

    @PostMapping(value = "/add/props",
            consumes = "text/properties;charset=UTF-8" // Content-Type 过滤媒体类型
    )
    /**
     * 可以不依赖@RequestBody 实现 Properties 格式请求内容，解析为 Properties 对象的方法参数
     */
    public Properties addProperties(//@RequestBody
                                    Properties properties) {
        return properties;
    }

}
