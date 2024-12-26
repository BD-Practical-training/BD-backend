package com.dongfangwutong.service;

import org.springframework.stereotype.Component;

@Component
public class Provider1FallbackService implements Provider1Service {

    @Override
    public String sayHello(String name) {
        return "Fallback...";
    }

}
