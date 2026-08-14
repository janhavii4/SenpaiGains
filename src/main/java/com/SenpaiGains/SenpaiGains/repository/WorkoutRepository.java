package com.SenpaiGains.SenpaiGains.repository;

import com.SenpaiGains.SenpaiGains.entity.Workout;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {
}
