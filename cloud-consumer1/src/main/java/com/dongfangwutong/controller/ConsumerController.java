package com.dongfangwutong.controller;

import com.dongfangwutong.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    @Resource
    FeignService feignService;

    @GetMapping("message")
    public String message() {
        return "Hello World";
    }

    @GetMapping("remoteFeign")
    public String remoteFeign(@RequestParam String name) {
        return feignService.sayHello(name);
    }
}
