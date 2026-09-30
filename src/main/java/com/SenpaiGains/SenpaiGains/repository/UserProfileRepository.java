package com.SenpaiGains.SenpaiGains.repository;

import com.SenpaiGains.SenpaiGains.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}