package com.example.placementtracker.repository; // Added .example

import com.example.placementtracker.model.Job;  // Added .example

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {
    // MongoRepository already gives you save(), findAll(), findById(), deleteById()
    // You can add custom finder methods just by naming them — Spring generates the query:
    // e.g. List<Job> findByStatus(String status);
    List<Job> findByStatus(String status);
    //containsIgnoreCase is used to perform a case-insensitive search for jobs based on the company name. This means that if you search for "Google", it will return jobs with company names like "google", "GOOGLE", or "GoOgLe".
    List<Job> findByCompanyContainingIgnoreCase(String company);
List<Job> findByRoleContainingIgnoreCase(String role);
List<Job> findAllByOrderByDeadlineAsc();
}