package com.sample.secondapp.manager;

import com.sample.secondapp.dto.PersonDto;
import com.sample.secondapp.entity.Person;
import com.sample.secondapp.mapper.EntityToDtoMapper;
import com.sample.secondapp.repository.PersonRepository;
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
        List<Person> personList = personRepository.findAll();
        log.info("Find {} persons", personList.size());
        return personList.stream().map(entityToDtoMapper::personToPersonDto).collect(Collectors.toList());
    }
}
