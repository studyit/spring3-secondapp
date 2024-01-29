package com.sample.secondapp.manager;

import com.sample.secondapp.dto.WorkoutDto;
import com.sample.secondapp.entity.Workout;
import com.sample.secondapp.mapper.EntityToDtoMapper;
import com.sample.secondapp.repository.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class WorkoutManager {

    private final WorkoutRepository workoutRepository;

    private final EntityToDtoMapper entityToDtoMapper;

    public WorkoutManager(final WorkoutRepository workoutRepository, final EntityToDtoMapper entityToDtoMapper) {
        this.workoutRepository = workoutRepository;
        this.entityToDtoMapper = entityToDtoMapper;
    }

    public List<WorkoutDto> getWorkouts(final String name) {
        List<Workout> workoutList = workoutRepository.findByName(name);
        log.info("Find {} workouts", workoutList.size());
        return workoutList.stream().map(entityToDtoMapper::workoutToWorkoutDto).collect(Collectors.toList());
    }

    public List<WorkoutDto> getWorkoutsIgnoreCase(final String name) {
        List<Workout> workoutList = workoutRepository.findByNameIsLikeIgnoreCase("%" + name + "%");
        log.info("Find {} workouts", workoutList.size());
        return workoutList.stream().map(entityToDtoMapper::workoutToWorkoutDto).collect(Collectors.toList());
    }
}
