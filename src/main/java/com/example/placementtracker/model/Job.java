package com.example.placementtracker.model; 


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "jobs")   // this becomes the collection name in Mongo
public class Job {

    @Id
    private String id;           // Mongo auto-generates this (ObjectId as string)
@NotBlank
    private String company;
    @NotBlank
    private String role;
    private String source;       // "WhatsApp", "LinkedIn", "Naukri", "Gmail", etc.
    private String jobLink;
    @NotBlank
    private String status;       // "SEEN", "APPLIED", "INTERVIEW", "REJECTED", "OFFER"
    private LocalDate postedDate;
    private LocalDate appliedDate;
    private LocalDate deadline;
    private String notes;
}