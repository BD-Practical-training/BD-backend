package com.dongfangwutong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProviderController")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(String name) {
        return "Hello provider1 " + name;
    }

}
