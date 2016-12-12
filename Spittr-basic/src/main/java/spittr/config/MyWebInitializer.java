package spittr.config;

import spittr.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置DispatcherServlet,代替web.xml方式
 * servlet3.0以下容器（tomcat7以下）只能用web.xml配置
 * Author LPJ
 * Date 2016/12/12
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    // 指定配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    // 将DispatcherServlet映射到"/"
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
