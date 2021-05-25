package com.niranjan2021.Conference.app.controller;


import com.niranjan2021.Conference.app.configprop.ExConfigProp;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@PropertySource("classpath:external_config.properties")
public class HomeController {


    @Autowired
    private ExConfigProp exConfigProp;

    public final  static Logger logger = Logger.getLogger(String.valueOf(MethodHandles.lookup().lookupClass()));
    @Value("${app.version}")
    private String version;

    @GetMapping("/version")
    public Map getAppVersion() {
        Map app = new HashMap<>();
        logger.info("Read external config properties "+exConfigProp.isConferenceapp());
        app.put("App-Version ", version);
        return app;
    }

}
