package com.sample.firstapp.dto;

import lombok.Data;

@Data
public class PersonDto {

    private Long personId;

    private String firstName;

    private String lastName;

    private String pseudo;

    private String email;
}
