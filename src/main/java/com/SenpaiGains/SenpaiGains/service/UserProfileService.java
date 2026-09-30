package com.SenpaiGains.SenpaiGains.service;

import com.SenpaiGains.SenpaiGains.entity.UserProfile;
import com.SenpaiGains.SenpaiGains.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile saveProfile(UserProfile profile) {
        return userProfileRepository.save(profile);
    }

    public UserProfile getLatestProfile() {
        return userProfileRepository.findAll()
                .stream()
                .reduce((first, second) -> second) // gets the last one saved
                .orElseThrow(() -> new RuntimeException("No profile found. Please complete onboarding first."));
    }

    public Map<String, Object> calculateTargets() {
        UserProfile profile = getLatestProfile();

        double bmr;
        if (profile.getGender().equalsIgnoreCase("Male")) {
            bmr = 10 * profile.getWeight() + 6.25 * profile.getHeight() - 5 * profile.getAge() + 5;
        } else {
            bmr = 10 * profile.getWeight() + 6.25 * profile.getHeight() - 5 * profile.getAge() - 161;
        }

        double activityMultiplier;
        switch (profile.getActivityLevel()) {
            case "Sedentary": activityMultiplier = 1.2; break;
            case "Moderate": activityMultiplier = 1.55; break;
            case "Active": activityMultiplier = 1.725; break;
            default: activityMultiplier = 1.375;
        }

        double tdee = bmr * activityMultiplier;

        if (profile.getGoal().equalsIgnoreCase("Lose Fat")) {
            tdee -= 400;
        } else if (profile.getGoal().equalsIgnoreCase("Build Muscle")) {
            tdee += 300;
        }

        double proteinMultiplier = profile.getGoal().equalsIgnoreCase("Build Muscle") ? 2.0 : 1.7;
        double proteinTarget = profile.getWeight() * proteinMultiplier;

        Map<String, Object> result = new HashMap<>();
        result.put("bmr", Math.round(bmr));
        result.put("calorieTarget", Math.round(tdee));
        result.put("proteinTarget", Math.round(proteinTarget));

        return result;
    }
}
