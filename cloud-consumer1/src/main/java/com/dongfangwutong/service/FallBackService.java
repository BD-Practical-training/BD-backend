package com.dongfangwutong.service;

import org.springframework.stereotype.Component;

@Component
public class FallBackService implements FeignService{

    @Override
    public String sayHello(String name) {
        return "Fallback...";
    }
}
