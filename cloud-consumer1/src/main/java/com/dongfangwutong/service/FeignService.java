package com.dongfangwutong.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "cloud-provider1",path = "/ProviderController",fallback = FallBackService.class)
public interface FeignService {

    @GetMapping("/hello")
    String sayHello(@RequestParam("name") String name);

}
