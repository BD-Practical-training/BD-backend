package com.dongfangwutong.service;

import com.primihub.sdk.task.param.TaskParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "cloud-provider3-primihub",path = "/PrimiHubController",fallback = PrimiHubFallbackService.class)
public interface PrimiHubService {

    @GetMapping("/pirTask")
    TaskParam<?> pirTask(@RequestParam("params") String[] params);
}
