package com.SenpaiGains.SenpaiGains.controller;

import com.SenpaiGains.SenpaiGains.entity.DietEntry;
import com.SenpaiGains.SenpaiGains.service.DietEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet")
public class DietEntryController {

    @Autowired
    private DietEntryService dietEntryService;

    @PostMapping
    public DietEntry addDietEntry(@RequestBody DietEntry dietEntry) {
        return dietEntryService.addDietEntry(dietEntry);
    }

    @GetMapping
    public List<DietEntry> getAllDietEntry() {
        return dietEntryService.getAllDietEntry();
    }

    @PutMapping("/{id}")
    public DietEntry updateDietEntry(@PathVariable Long id, @RequestBody DietEntry dietEntry) {
        return dietEntryService.updateDietEntry(id, dietEntry);
    }

    @DeleteMapping("/{id}")
    public String deleteDietEntry(@PathVariable Long id) {
        dietEntryService.deleteDietEntry(id);
        return "Diet Entry deleted successfully";
    }
}