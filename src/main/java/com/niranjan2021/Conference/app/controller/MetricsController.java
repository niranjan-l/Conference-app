package com.niranjan2021.Conference.app.controller;

import com.niranjan2021.Conference.app.customactuator.metrics.CustomizeMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/v1/custom-metrics")
public class MetricsController {

    @Autowired
    private  CustomizeMetrics customizeMetrics;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String metricsTest() throws Exception {

        customizeMetrics.longRunningOperation();
        return "true";
    }
}
