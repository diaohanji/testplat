package com.yskj.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/hello")
    public String say() {
        return "helloworld";
    }

    @RequestMapping("/new")
    public String new1() {
        return "new";
    }

}
       