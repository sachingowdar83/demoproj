package com.sachin.ex.demoproj.repo;

import com.sachin.ex.demoproj.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
