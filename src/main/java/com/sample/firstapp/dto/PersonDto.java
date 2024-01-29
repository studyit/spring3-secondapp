package com.sample.firstapp.dto;

public record PersonDto(Long personId,
                        String firstName,
                        String lastName,
                        String pseudo,
                        String email) {
}
