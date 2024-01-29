package com.sample.secondapp.controller;

import com.sample.secondapp.dto.WorkoutDto;
import com.sample.secondapp.manager.WorkoutManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class WorkoutController {

    private final WorkoutManager workoutManager;

    public WorkoutController(final WorkoutManager workoutManager) {
        this.workoutManager = workoutManager;
    }

    @GetMapping("/workouts")
    public List<WorkoutDto> getAllWorkout(@RequestParam("name") String name) {
        return workoutManager.getWorkouts(name);
    }

    @GetMapping("/workoutsIgnoreCase")
    public List<WorkoutDto> getAllWorkoutIgnoreCase(@RequestParam("name") String name) {
        return workoutManager.getWorkoutsIgnoreCase(name);
    }
}
