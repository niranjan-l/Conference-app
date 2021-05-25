package com.niranjan2021.Conference.app.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Sessions {
    public Sessions() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;


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
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public String getSession_length() {
        return session_length;
    }

    public void setSession_length(String session_length) {
        this.session_length = session_length;
    }

    private String session_length;
}
