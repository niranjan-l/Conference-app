package com.niranjan2021.Conference.app.repository;

import com.niranjan2021.Conference.app.models.Speakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakersRespository extends JpaRepository<Speakers,Long> {
}
