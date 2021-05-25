package com.niranjan2021.Conference.app.controller;


import com.niranjan2021.Conference.app.models.Sessions;
import com.niranjan2021.Conference.app.repository.SessionsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionsRepository sessionsRepository;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Sessions> getAll() {
        return sessionsRepository.findAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sessions getById(@PathVariable Long id) {
        return sessionsRepository.getOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Sessions create(@RequestBody Sessions sessions) {
        return sessionsRepository.saveAndFlush(sessions);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        sessionsRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Sessions update( @PathVariable Long id, @RequestBody Sessions newsessions) {
        Sessions existingSession = sessionsRepository.getOne(id);
        BeanUtils.copyProperties(newsessions, existingSession, "session_id");

        return sessionsRepository.saveAndFlush(existingSession);

    }

}
