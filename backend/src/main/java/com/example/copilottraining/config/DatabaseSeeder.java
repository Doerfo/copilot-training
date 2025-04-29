package com.example.copilottraining.config;

import com.example.copilottraining.model.CatProfile;
import com.example.copilottraining.repository.CatProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    public CommandLineRunner seedDatabase(CatProfileRepository repository) {
        return args -> {
            System.out.println("Seeding database...");
            repository.save(new CatProfile(1L, "Whiskers", 2, "Siamese", "A playful Siamese cat."));
            repository.save(new CatProfile(2L, "Mittens", 3, "Persian", "A calm Persian cat."));
            repository.save(new CatProfile(3L, "Shadow", 1, "Maine Coon", "A curious Maine Coon kitten."));
        };
    }
}