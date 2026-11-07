package com.arikaran.jobtracker.repository;

import com.arikaran.jobtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}