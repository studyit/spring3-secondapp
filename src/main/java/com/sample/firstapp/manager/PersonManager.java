package com.sample.firstapp.manager;

import com.sample.firstapp.dto.PersonDto;
import com.sample.firstapp.entity.User;
import com.sample.firstapp.mapper.EntityToDtoMapper;
import com.sample.firstapp.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PersonManager {

    private final PersonRepository personRepository;

    private final EntityToDtoMapper entityToDtoMapper;

    public PersonManager(final PersonRepository personRepository, final EntityToDtoMapper entityToDtoMapper) {
        this.personRepository = personRepository;
        this.entityToDtoMapper = entityToDtoMapper;
    }

    public List<PersonDto> getAllPerson() {
        List<User> personList = personRepository.findAll();
        log.info("Find {} persons", personList.size());
        return personList.stream().map(entityToDtoMapper::userToPersonDto).collect(Collectors.toList());
    }
}
