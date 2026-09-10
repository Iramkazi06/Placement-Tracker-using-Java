package com.example.placementtracker.controller;
import jakarta.validation.Valid;
import com.example.placementtracker.model.Job;
import com.example.placementtracker.service.JobService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // GET all jobs
 @GetMapping
public List<Job> getJobs(
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String company,
        @RequestParam(required = false) String role,
    @RequestParam(required=false) String sortBy) {

    if (status != null) {
        return jobService.getJobsByStatus(status);
    }

    if (company != null) {
        return jobService.getJobsByCompany(company);
    }
    if(role!=null){
        return jobService.getJobsByRole(role);
    }
    if("deadline".equalsIgnoreCase(sortBy)){
        return jobService.getJobsSortedByDeadLine();
    }

    return jobService.getAllJobs();
}

    // GET a single job by ID
    @GetMapping("/{id}")
    public Optional<Job> getJobById(@PathVariable String id) {
        return jobService.getJobById(id);
    }



    // POST - add a new job
    
    @PostMapping
public Job addJob(@Valid @RequestBody Job job) {
    return jobService.addJob(job);
}

    // PUT - update an existing job
    @PutMapping("/{id}")
    public Job updateJob(
            @PathVariable String id,
            @RequestBody Job updatedJob) {

        return jobService.updateJob(id, updatedJob);
    }

    // DELETE - delete a job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable String id) {

        jobService.deleteJob(id);

        return "Job application deleted successfully!";
    }
}
