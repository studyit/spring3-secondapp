package com.sample.secondapp.dto;

import java.util.Set;

public record PersonDto(Long personId,
                        String firstName,
                        String lastName,
                        String pseudo,
                        String email,
                        Set<WorkoutDto> workouts) {
}
