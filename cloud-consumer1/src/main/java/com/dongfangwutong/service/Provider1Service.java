package com.dongfangwutong.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "cloud-provider1", path = "/ProviderController", fallback = Provider1FallbackService.class)
public interface Provider1Service {

    @GetMapping("/hello")
    String sayHello(@RequestParam("name") String name);

}
