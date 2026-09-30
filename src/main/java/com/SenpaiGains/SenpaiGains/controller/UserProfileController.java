package com.SenpaiGains.SenpaiGains.controller;

import com.SenpaiGains.SenpaiGains.entity.UserProfile;
import com.SenpaiGains.SenpaiGains.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public UserProfile saveProfile(@RequestBody UserProfile profile) {
        return userProfileService.saveProfile(profile);
    }

    @GetMapping
    public UserProfile getProfile() {
        return userProfileService.getLatestProfile();
    }

    @GetMapping("/targets")
    public Map<String, Object> getTargets() {
        return userProfileService.calculateTargets();
    }
}
