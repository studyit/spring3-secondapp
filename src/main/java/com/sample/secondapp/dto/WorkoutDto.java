package com.sample.secondapp.dto;

import java.time.LocalDate;

public record WorkoutDto(
        Long workoutId,
        String name,
        LocalDate date,
        Double distance,
        Double up,
        Double down
) {
}
