package com.niranjan2021.Conference.app.customactuator;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "monitorapp")
public class CustomEndPoint {


    private   String readiness="NOT_READY";
    private   String data;
    @ReadOperation
    public String getReadiness(){
        return  readiness+" "+data;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setReadinessReadiness(){

        readiness="Ready";
    }

    @WriteOperation
    public void writeData( String data){

        this.data=data;


    }


}
