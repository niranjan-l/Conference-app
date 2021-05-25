package com.niranjan2021.Conference.app.controller;


import com.niranjan2021.Conference.app.models.Sessions;
import com.niranjan2021.Conference.app.models.Speakers;
import com.niranjan2021.Conference.app.repository.SpeakersRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {


    @Autowired
    public  SpeakersRespository speakersRespository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Speakers> getAll()
    {
        return  speakersRespository.findAll();

    }


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Speakers getbyId(@PathVariable Long id)
    {
        return  speakersRespository.getOne(id);

    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Speakers create(@RequestBody Speakers speakers) {
        return speakersRespository.saveAndFlush(speakers);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        speakersRespository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Speakers update(@PathVariable Long id, @RequestBody Speakers newspeakers) {
        Speakers existingSpeakers = speakersRespository.getOne(id);
        BeanUtils.copyProperties(newspeakers, existingSpeakers, "speaker_id");

        return speakersRespository.saveAndFlush(existingSpeakers);


    }

}
