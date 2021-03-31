package com.xz.support;

import com.xz.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties} {@link HandlerMethodArgumentResolver}
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        // 复用 PropertiesHttpMessageConverter
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        // Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();

        HttpInputMessage httpInputMessage = new ServletServerHttpRequest(request);

        return converter.read(null, null, httpInputMessage);



/*        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        HttpServletRequest request = servletWebRequest.getRequest();

        String contentType = request.getHeader("Content-Type");

        //获取到请求头中的Content-Type 中的媒体类型
        MediaType mediaType = MediaType.parseMediaType(contentType);

        //获取字符编码
        Charset charset = mediaType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;

        //请求输入字节流
        ServletInputStream inputStream = request.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        Properties properties = new Properties();
        //加载字符流为Properties对象
        properties.load(inputStreamReader);

        return properties;*/
    }
}
