package com.sample.secondapp.manager;

import com.sample.secondapp.dto.PersonDto;
import com.sample.secondapp.entity.Person;
import com.sample.secondapp.exceptions.UnknownPersonException;
import com.sample.secondapp.mapper.EntityToDtoMapper;
import com.sample.secondapp.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
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

    public PersonDto getPerson(final Long personId) throws UnknownPersonException {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        return optionalPerson.map(entityToDtoMapper::personToPersonDto).orElseThrow(()-> new UnknownPersonException("Person with id " + personId + " not found"));
    }

    public PersonDto createPerson(PersonDto personDto) {
        Person person = entityToDtoMapper.personDtoToPerson(personDto);
        Person newPerson = personRepository.save(person);
        return entityToDtoMapper.personToPersonDto(newPerson);
    }
}
