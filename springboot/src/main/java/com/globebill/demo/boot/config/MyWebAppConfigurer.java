package com.globebill.demo.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Author lpj
 * Date 2016/8/3
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/realpath/**").addResourceLocations("file:D:/work/");
        registry.addResourceHandler("/mypath/**").addResourceLocations("classpath:/mypath/");
        super.addResourceHandlers(registry);
    }
}
