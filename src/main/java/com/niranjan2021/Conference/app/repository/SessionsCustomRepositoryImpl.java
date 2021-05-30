package com.niranjan2021.Conference.app.repository;

import com.niranjan2021.Conference.app.models.Sessions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SessionsCustomRepositoryImpl implements  SessionsCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Sessions> getSessions() {
        return entityManager.createQuery("select s from Sessions s").getResultList();
    }
}
