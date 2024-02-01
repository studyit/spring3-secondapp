package com.sample.secondapp.mapper;

import com.sample.secondapp.dto.PersonDto;
import com.sample.secondapp.dto.WorkoutDto;
import com.sample.secondapp.entity.Person;
import com.sample.secondapp.entity.Workout;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EntityToDtoMapper {
    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto personDto);

    WorkoutDto workoutToWorkoutDto(Workout workout);
}
