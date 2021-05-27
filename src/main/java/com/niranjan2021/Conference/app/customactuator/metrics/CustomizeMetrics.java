package com.niranjan2021.Conference.app.customactuator.metrics;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;


@Service
public class CustomizeMetrics {

    private Timer timer;


    public  CustomizeMetrics(MeterRegistry meterRegistry){

        timer = meterRegistry.timer("long.running.op.timer");

    }

    public  void longRunningOperation() throws  Exception{
        timer.record(()->{
            try {
               Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
