package com.niranjan2021.Conference.app.models;


import com.niranjan2021.Conference.app.repository.SessionsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionsTest {

    @Autowired
    SessionsRepository sessionsRepository;

    @Test
    public  void  pageSessionsTest(){

        Page<Sessions> sessionsWithName = sessionsRepository.getSessionsWithName("S", PageRequest.of(1, 5, Sort.by(Sort.Direction.DESC, "sessionLength")));
        assertTrue(sessionsWithName.getTotalElements()>0);
    }


    @Test
    public  void  customSessionsTest(){

        List<Sessions> sessions = sessionsRepository.getSessions();
        assertTrue(sessions.size()>0);
    }

}
