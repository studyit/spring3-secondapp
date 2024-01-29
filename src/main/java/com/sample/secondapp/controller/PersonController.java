package com.sample.secondapp.controller;

import com.sample.secondapp.dto.PersonDto;
import com.sample.secondapp.manager.PersonManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
