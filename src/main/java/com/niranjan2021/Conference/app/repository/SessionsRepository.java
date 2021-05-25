package com.niranjan2021.Conference.app.repository;

import com.niranjan2021.Conference.app.models.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionsRepository extends JpaRepository<Sessions,Long> {
}
