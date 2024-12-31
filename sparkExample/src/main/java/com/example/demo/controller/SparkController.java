package com.example.demo.controller;

import com.example.demo.service.SparkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spark")
public class SparkController {

    @Autowired
    private SparkService sparkService;

    // Endpoint to process text file
    @GetMapping("/processTextFile")
    public String processTextFile() {
        try {
            sparkService.processTextFile();
            return "Text file processed successfully!";
        } catch (Exception e) {
            return "Error processing text file: " + e.getMessage();
        }
    }

    // Endpoint to process DataFrame (CSV file)
    @GetMapping("/processDataFrame")
    public String processDataFrame() {
        try {
            sparkService.processDataFrame();
            return "DataFrame processed successfully!";
        } catch (Exception e) {
            return "Error processing DataFrame: " + e.getMessage();
        }
    }
}
