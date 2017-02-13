package com.globebill.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
/**
 * Author lpj
 * Date 2016/7/26
 */
@SpringBootApplication
@EnableWebMvc
public class DemoBootApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoBootApplication.class, args);

        System.out.println("通过SpringBoot来注入依赖:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
