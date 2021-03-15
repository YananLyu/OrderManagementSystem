package com.astronet.oms.config;

import com.astronet.oms.convertors.enumconvertor.factory.IntegerCodeToEnumConverterFactory;
import com.astronet.oms.convertors.enumconvertor.factory.StringCodeToEnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  <p>
 *  MVC通用配置
 *  </p>
 *
 * @description: MVC通用配置
 * @author Yanan Lyu
 * @date 3/14/21 3:40 PM
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 枚举类的转换器工厂 addConverterFactory
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new IntegerCodeToEnumConverterFactory());
        registry.addConverterFactory(new StringCodeToEnumConverterFactory());
    }
}
