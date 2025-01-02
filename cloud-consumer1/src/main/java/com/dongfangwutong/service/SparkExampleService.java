package com.dongfangwutong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "sparkExample", path = "/SparkController")
public interface SparkExampleService {

    @GetMapping("/processTextFile")
    String processTextFile();

}
