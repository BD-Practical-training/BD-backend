package com.dongfangwutong.controller;

import com.dongfangwutong.service.Provider1Service;
import com.dongfangwutong.service.PrimiHubService;
import com.primihub.sdk.task.param.TaskParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    @Resource
    Provider1Service provider1Service;
    @Resource
    PrimiHubService primiHubService;

    @GetMapping("/message")
    public String message() {
        return "Hello World";
    }

    @GetMapping("/remoteFeign")
    public String remoteFeign(@RequestParam String name) {
        return provider1Service.sayHello(name);
    }

    @PostMapping("/feignPirTask")
    public TaskParam<?> pirTask(@RequestBody List<String> params) {
        System.out.println("receive params:" + params);
        return primiHubService.pirTask(params.toArray(new String[0]));
    }
}
