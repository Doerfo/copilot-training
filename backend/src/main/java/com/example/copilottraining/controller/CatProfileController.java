package com.example.copilottraining.controller;

import com.example.copilottraining.model.CatProfile;
import com.example.copilottraining.service.CatProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatProfileController {

    @Autowired
    private CatProfileService catProfileService;

    @GetMapping
    public List<CatProfile> getAllCatProfiles() {
        return catProfileService.getAllCatProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatProfile> getCatProfileById(@PathVariable Long id) {
        CatProfile catProfile = catProfileService.getCatProfileById(id).orElse(null);
        return catProfile != null ? ResponseEntity.ok(catProfile) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CatProfile createCatProfile(@RequestBody CatProfile catProfile) {
        return catProfileService.createCatProfile(catProfile);
    }

    @PostMapping("/random")
    public CatProfile createRandomCatProfile() {
        return catProfileService.createRandomCatProfile();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatProfile> updateCatProfile(@PathVariable Long id, @RequestBody CatProfile catProfile) {
        CatProfile updatedCatProfile = catProfileService.updateCatProfile(id, catProfile);
        return updatedCatProfile != null ? ResponseEntity.ok(updatedCatProfile) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatProfile(@PathVariable Long id) {
        return catProfileService.deleteCatProfile(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}