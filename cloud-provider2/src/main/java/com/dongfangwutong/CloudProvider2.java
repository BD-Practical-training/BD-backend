package com.dongfangwutong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudProvider2 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProvider2.class, args);
    }
}
