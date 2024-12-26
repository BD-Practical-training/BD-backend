package com.dongfangwutong.controller;

import com.primihub.sdk.config.GrpcClientConfig;
import com.primihub.sdk.task.TaskHelper;
import com.primihub.sdk.task.param.TaskPIRParam;
import com.primihub.sdk.task.param.TaskParam;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("PrimiHubController")
public class PrimiHubController {

    @GetMapping("/pirTask")
    public TaskParam<?> pirTask(@RequestParam("params") String[] params){
        // 设置node地址信息
        GrpcClientConfig grpcClientConfig = new GrpcClientConfig();
        grpcClientConfig.setAddress("127.0.0.1");
        grpcClientConfig.setPort(50050);
        // 获取任务帮助类
        try {
            TaskHelper taskHelper = TaskHelper.getInstance(grpcClientConfig);
            // 发起一个PIR任务
            TaskParam<TaskPIRParam> taskParam = new TaskParam<>(new TaskPIRParam());
            // 设置taskID
            taskParam.setTaskId(UUID.randomUUID().toString().replace("-",""));
            // 设置PIR参数
            taskParam.getTaskContentParam().setServerData("keyword_pir_server_data");
            taskParam.getTaskContentParam().setQueryParam(params);
            taskParam.getTaskContentParam().setOutputFullFilename("./data/result/pir_sdk_result.csv");
            // 提交任务 - 阻塞持续获取任务状态
            taskHelper.submit(taskParam);
            return taskParam;
        }catch (Exception e){
            System.out.println("错误信息:");
            e.printStackTrace();
        }
        return null;
    }

}
