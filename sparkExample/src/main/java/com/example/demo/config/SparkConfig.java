package com.example.demo.config;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    // 配置 Spark
    @Bean
    public SparkSession sparkSession() {
        return SparkSession.builder()
                .appName("Spring Boot and Spark Example")
                .master("local[*]") // 运行在本地，使用多核
                .getOrCreate();
    }

    @Bean
    public JavaSparkContext javaSparkContext(SparkSession sparkSession) {
        return new JavaSparkContext(sparkSession.sparkContext());
    }
}
