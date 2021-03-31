package com.xz.http.converter.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * REST {@link WebMvcConfigurer} 实现
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter() {
        super(new MediaType("text", "properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //properties  ->String
        //OutputStream ->Writer
        //字节输出流
        OutputStream outputStream = outputMessage.getBody();

        HttpHeaders headers = outputMessage.getHeaders();
        MediaType mediaType = headers.getContentType();
        //获取字符编码
        Charset charset = mediaType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;


        //字符输出流
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);

        //properties写入到字符输出流
        properties.store(writer, "From PropertiesHttpMessageConverter");

    }


    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        //拿到请求头
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType mediaType = headers.getContentType();
        //获取字符编码
        Charset charset = mediaType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;

        //字节流
        InputStream inputStream = inputMessage.getBody();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        Properties properties = new Properties();
        //加载字符流为Properties对象
        properties.load(inputStreamReader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}

