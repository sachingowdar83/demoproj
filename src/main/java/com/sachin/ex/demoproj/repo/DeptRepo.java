package com.sachin.ex.demoproj.repo;

import com.sachin.ex.demoproj.entities.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepo extends JpaRepository<DeptEntity,Long> {
}
