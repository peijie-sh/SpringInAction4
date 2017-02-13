package com.globebill.demo.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author lpj
 * Date 2016/7/26
 */
@RestController
public class DemoController {

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        System.out.println("index page coming");
        return "index";
    }

    @RequestMapping("/demo")
    public String indexDemo() {
        return "home demo page";
    }

}
