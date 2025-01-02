package com.example.demo.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SparkService {

    @Autowired
    private SparkSession sparkSession;

    @Autowired
    private JavaSparkContext javaSparkContext;

    // 读取文本文件并执行简单的 RDD 操作
    public void processTextFile() {
        // 加载文本文件到 RDD
        JavaRDD<String> rdd = javaSparkContext.textFile("D://东方物通实习/data/sample.txt");

        // 执行简单的 RDD 操作
        long lineCount = rdd.count();
        System.out.println("Number of lines in the file: " + lineCount);

        // 可以执行其他 RDD 操作，例如 map、filter 等
    }

    // 使用 Spark SQL 查询数据
    public void processDataFrame() {
        // 读取数据文件到 DataFrame（例如 CSV）
        //Dataset<Row> df = sparkSession.read().option("header", "true").csv("D://东方物通实习/data/sample.csv");
        Dataset<Row> df = sparkSession.read()
                .option("header", "true") // 使用第一行作为列名
                .option("inferSchema", "true") // 自动推断数据类型
                .option("encoding", "UTF-8")
                .csv("D://东方物通实习/data/sample.csv");
        // 显示 DataFrame 内容
        df.show(false);

        // 执行 Spark SQL 查询
        df.createOrReplaceTempView("data_table");
        Dataset<Row> sqlResult = sparkSession.sql("SELECT * FROM data_table WHERE age > 10");
        sqlResult.show(false);
    }
}
