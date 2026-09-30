package com.SenpaiGains.SenpaiGains.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

    @Entity
    @Data
    public class UserProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int age;
        private double weight;
        private double height;
        private String gender;
        private String activityLevel;
        private String goal;
    }

