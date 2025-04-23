package com.example.copilottraining.service;

import com.example.copilottraining.model.CatProfile;
import com.example.copilottraining.repository.CatProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CatProfileService {

    private final CatProfileRepository catProfileRepository;

    @Autowired
    public CatProfileService(CatProfileRepository catProfileRepository) {
        this.catProfileRepository = catProfileRepository;
    }

    public List<CatProfile> getAllCatProfiles() {
        return catProfileRepository.findAll();
    }

    public Optional<CatProfile> getCatProfileById(Long id) {
        return catProfileRepository.findById(id);
    }

    public CatProfile createCatProfile(CatProfile catProfile) {
        return catProfileRepository.save(catProfile);
    }

    public CatProfile updateCatProfile(Long id, CatProfile catProfileDetails) {
        CatProfile catProfile = catProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CatProfile not found with id " + id));
        catProfile.setName(catProfileDetails.getName());
        catProfile.setAge(catProfileDetails.getAge());
        catProfile.setBreed(catProfileDetails.getBreed());
        catProfile.setDescription(catProfileDetails.getDescription());
        return catProfileRepository.save(catProfile);
    }

    public boolean deleteCatProfile(Long id) {
        if (catProfileRepository.existsById(id)) {
            catProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public CatProfile createRandomCatProfile() {
        Random random = new Random();
        CatProfile randomCat = new CatProfile();
        randomCat.setName("RandomCat" + random.nextInt(1000));
        randomCat.setAge(random.nextInt(20));
        randomCat.setBreed("RandomBreed");
        randomCat.setDescription("A randomly generated cat profile.");
        return catProfileRepository.save(randomCat);
    }
}