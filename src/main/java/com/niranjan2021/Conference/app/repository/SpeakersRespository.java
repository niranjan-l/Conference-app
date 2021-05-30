package com.niranjan2021.Conference.app.repository;

import com.niranjan2021.Conference.app.models.Speakers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakersRespository extends JpaRepository<Speakers,Long> {

    List<Speakers> findByFirstNameAndLastName(String firstName ,String lastName);
    List<Speakers> findByFirstNameOrLastName(String firstName ,String lastName);
}

