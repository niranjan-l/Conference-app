package com.niranjan2021.Conference.app.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Sessions {
    public Sessions() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "session_description")
    private String sessionDescription;



    @Column(name = "session_length")
    private String sessionLength;



    public List<Speakers> getSpeakersList() {
        return speakersList;
    }

    public void setSpeakersList(List<Speakers> speakersList) {
        this.speakersList = speakersList;
    }

    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns =  @JoinColumn(name = "speaker_id")
    )
    private List<Speakers> speakersList;


    public Long getSession_id() {
        return sessionId;
    }

    public void setSession_id(Long session_id) {
        this.sessionId = sessionId;
    }

    public String getSession_name() {
        return sessionName;
    }

    public void setSession_name(String session_name) {
        this.sessionName = sessionName;
    }

    public String getSession_description() {
        return sessionDescription;
    }

    public void setSession_description(String session_description) {
        this.sessionDescription = sessionDescription;
    }

    public String getSession_length() {
        return sessionLength;
    }

    public void setSession_length(String sessionLength) {
        this.sessionLength = sessionLength;
    }

}
