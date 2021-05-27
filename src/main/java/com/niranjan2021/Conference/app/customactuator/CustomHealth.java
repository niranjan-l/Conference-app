package com.niranjan2021.Conference.app.customactuator;


import com.niranjan2021.Conference.app.configprop.ExConfigProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

@Component
public class CustomHealth implements HealthIndicator {
    public final static Logger logger = Logger.getLogger(String.valueOf(MethodHandles.lookup().lookupClass()));

    @Autowired
    private ExConfigProp exConfigProp;

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(true);
    }

    @Override
    public Health health() {
        if(exConfigProp.isConferenceapp())
        return Health.down().withDetail("disabled",exConfigProp).build();
        return Health.up().build();
    }
}
