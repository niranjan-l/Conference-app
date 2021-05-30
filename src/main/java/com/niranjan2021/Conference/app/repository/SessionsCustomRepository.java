package com.niranjan2021.Conference.app.repository;

import com.niranjan2021.Conference.app.models.Sessions;

import java.util.List;

public interface SessionsCustomRepository {

    public List<Sessions> getSessions();
}
