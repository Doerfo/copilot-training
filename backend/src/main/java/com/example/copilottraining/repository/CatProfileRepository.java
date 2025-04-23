package com.example.copilottraining.repository;

import com.example.copilottraining.model.CatProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatProfileRepository extends JpaRepository<CatProfile, Long> {
}