package com.dongfangwutong.service;

import com.primihub.sdk.task.param.TaskPIRParam;
import com.primihub.sdk.task.param.TaskParam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PrimiHubFallbackService implements PrimiHubService {

    @Override
    public TaskParam<?> pirTask(String[] params) {
        return new TaskParam<TaskPIRParam>(){{this.setSuccess(false);this.setError("服务熔断");}};
    }
}
