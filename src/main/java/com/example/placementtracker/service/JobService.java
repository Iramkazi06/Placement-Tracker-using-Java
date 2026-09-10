package com.example.placementtracker.service;

import com.example.placementtracker.model.Job;
import com.example.placementtracker.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Get all jobs
  
public List<Job> getJobsByStatus(String status) {
    return jobRepository.findByStatus(status);
}

//search jpbs by company
public List<Job> getJobsByCompany(String company){
return jobRepository.findByCompanyContainingIgnoreCase(company);
}
//search jobs by role
public List<Job> getJobsByRole(String role){
    return jobRepository.findByRoleContainingIgnoreCase(role);
}
public List<Job> getAllJobs() {
    return jobRepository.findAll();
}
    // Get job by ID
    public Optional<Job> getJobById(String id) {
        return jobRepository.findById(id);
    }
//get jobs sorted by deadline -ascending
public List<Job> getJobsSortedByDeadLine(){
    return jobRepository. findAllByOrderByDeadlineAsc();
}
    // Add new job
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    // Update job
    public Job updateJob(String id, Job updatedJob) {

        return jobRepository.findById(id)
                .map(job -> {

                    job.setCompany(updatedJob.getCompany());
                    job.setRole(updatedJob.getRole());
                    job.setSource(updatedJob.getSource());
                    job.setJobLink(updatedJob.getJobLink());
                    job.setStatus(updatedJob.getStatus());
                    job.setPostedDate(updatedJob.getPostedDate());
                    job.setAppliedDate(updatedJob.getAppliedDate());
                    job.setDeadline(updatedJob.getDeadline());
                    job.setNotes(updatedJob.getNotes());

                    return jobRepository.save(job);
                })
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
    }

    // Delete job
    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }
}