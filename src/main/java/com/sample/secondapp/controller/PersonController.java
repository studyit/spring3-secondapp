package com.sample.secondapp.controller;

import com.sample.secondapp.dto.PersonDto;
import com.sample.secondapp.dto.WorkoutDto;
import com.sample.secondapp.exceptions.UnknownPersonException;
import com.sample.secondapp.manager.PersonManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
public class PersonController {

    private final PersonManager personManager;

    public PersonController(final PersonManager personManager) {
        this.personManager = personManager;
    }

    @GetMapping("/persons")
    public List<PersonDto> getAllPerson() {
        return personManager.getAllPerson();
    }

    @GetMapping(value = "/person/{personId}", produces = {"application/json", "application/problem+json"})
    public PersonDto getPerson(@PathVariable("personId") Long personId) {
        try {
            return personManager.getPerson(personId);
        } catch (UnknownPersonException upe) {
            ResponseStatusException responseStatusException = new ResponseStatusException(HttpStatus.NOT_FOUND, upe.getMessage(), upe);
            responseStatusException.setTitle("Person not Found");
            throw responseStatusException;
        }
    }

    @PostMapping(value = "/person", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personManager.createPerson(personDto);
    }
}
