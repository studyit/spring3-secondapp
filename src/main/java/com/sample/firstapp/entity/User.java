package com.sample.firstapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name="PERSON")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="PERSON_ID", nullable=false)
    private Long personId;

    @Column(name="FIRST_NAME", length=100)
    private String firstName;

    @Column(name="LAST_NAME", length=100)
    private String lastName;

    @Column(name="PSEUDO", length=100)
    private String pseudo;

    @Column(name="EMAIL", length=100)
    private String email;

    @OneToMany(mappedBy="user")
    private Set<Workout> workouts;
}
