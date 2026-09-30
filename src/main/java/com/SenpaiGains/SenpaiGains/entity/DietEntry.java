package com.SenpaiGains.SenpaiGains.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

    @Entity
    @Data
    public class DietEntry {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String mealName;
        private int calories;
        private double protein;
        private LocalDate date;
    }

