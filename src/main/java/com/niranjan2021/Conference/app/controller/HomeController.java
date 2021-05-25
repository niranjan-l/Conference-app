package com.niranjan2021.Conference.app.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@PropertySource("classpath:external_config.properties")
public class HomeController {

    @Value("${app.version}")
    private String version;

    @GetMapping("/version")
    public Map getAppVersion() {
        Map app = new HashMap<>();
        app.put("App-Version ", version);
        return app;
    }

}
