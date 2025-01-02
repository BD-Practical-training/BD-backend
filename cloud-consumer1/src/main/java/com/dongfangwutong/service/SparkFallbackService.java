package com.dongfangwutong.service;

import org.springframework.stereotype.Component;

@Component
public class SparkFallbackService implements SparkExampleService {

    @Override
    public String processTextFile() {
        return "Fallback...";
    }
}
