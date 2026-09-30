package com.SenpaiGains.SenpaiGains.service;

import com.SenpaiGains.SenpaiGains.entity.DietEntry;
import com.SenpaiGains.SenpaiGains.repository.DietEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietEntryService {

    @Autowired
    private DietEntryRepository dietEntryRepository;

    public DietEntry addDietEntry(DietEntry entry) {
        return dietEntryRepository.save(entry);
    }

    public List<DietEntry> getAllDietEntry() {
        return dietEntryRepository.findAll();
    }

    public DietEntry updateDietEntry(Long id, DietEntry updatedDietEntry) {
        DietEntry existing = dietEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DietEntry not found with id: " + id));
        existing.setMealName(updatedDietEntry.getMealName());
        existing.setCalories(updatedDietEntry.getCalories());
        existing.setProtein(updatedDietEntry.getProtein());
        existing.setDate(updatedDietEntry.getDate());

        return dietEntryRepository.save(existing);
    }

    public void deleteDietEntry(Long id) {
        dietEntryRepository.deleteById(id);
    }
}
