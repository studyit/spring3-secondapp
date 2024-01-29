package com.sample.secondapp.repository;

import com.sample.secondapp.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query("select w from WORKOUT w where w.name like %:name%")
    List<Workout> findByName(@Param("name") String name);

    List<Workout> findByNameIsLikeIgnoreCase(String name);
}
