package com.niranjan2021.Conference.app.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Speakers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="speaker_id" )
    private  Long speakerId;
    @Column(name ="first_name" )
    private  String firstName;
    @Column(name ="last_name" )
    private  String lastName;
    @Column(name ="title" )
    private  String title;

    public Speakers() {
    }


    public List<Sessions> getSessionsList() {
        return sessionsList;
    }

    public void setSessionsList(List<Sessions> sessionsList) {
        this.sessionsList = sessionsList;
    }

    @ManyToMany(mappedBy = "speakersList")
    @JsonIgnore
    private List<Sessions> sessionsList;



    @Column(name ="company" )
    private  String company;
    @Column(name ="speaker_bio" )
    private  String speakerBio;

    @Lob
    @Type(type ="org.hibernate.type.ByteType")
    @Column(name ="speaker_photo" )
    private  byte[] speakerPhoto;

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeakerBio() {
        return speakerBio;
    }

    public void setSpeakerBio(String speakerBio) {
        this.speakerBio = speakerBio;
    }

    public byte[] getSpeakerPhoto() {
        return speakerPhoto;
    }

    public void setSpeakerPhoto(byte[] speakerPhoto) {
        this.speakerPhoto = speakerPhoto;
    }
}
