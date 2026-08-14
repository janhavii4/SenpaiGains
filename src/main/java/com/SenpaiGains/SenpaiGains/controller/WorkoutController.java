package com.SenpaiGains.SenpaiGains.controller;

import com.SenpaiGains.SenpaiGains.entity.Workout;
import com.SenpaiGains.SenpaiGains.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
     private WorkoutService workoutService;

    @PostMapping
     public Workout addWorkout(@RequestBody Workout workout) {
         return workoutService.addWorkout(workout);
     }

     @GetMapping
     public List<Workout> getAllWorkout() {
         return workoutService.getAllWorkouts();
     }

}
