package com.sample.secondapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name="WORKOUT")
public class Workout {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="WORKOUT_ID", nullable=false)
    private Long workoutId;

    @Column(name="NAME", length=100)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE")
    private LocalDate date;

    @Column(name="DISTANCE")
    private Double distance;

    @Column(name="UP")
    private Double up;

    @Column(name="DOWN")
    private Double down;

    @ManyToOne
    @JoinColumn(name="PERSON_ID", nullable=false)
    private Person person;
}
