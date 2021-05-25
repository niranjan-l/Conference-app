package com.niranjan2021.Conference.app.configprop;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
public class ExConfigProp {


    public boolean isConferenceapp() {
        return conferenceapp;
    }

    public void setConferenceapp(boolean conferenceapp) {
        this.conferenceapp = conferenceapp;
    }

    private  boolean conferenceapp;
}
