package com.sample.firstapp.mapper;

import com.sample.firstapp.dto.PersonDto;
import com.sample.firstapp.dto.WorkoutDto;
import com.sample.firstapp.entity.Person;
import com.sample.firstapp.entity.Workout;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EntityToDtoMapper {
    PersonDto personToPersonDto(Person person);

    WorkoutDto workoutToWorkoutDto(Workout workout);
}
