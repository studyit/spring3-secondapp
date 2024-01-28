package com.sample.firstapp.repository;

import com.sample.firstapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<User, Long> {
}
