package com.arikaran.jobtracker.controller;

import com.arikaran.jobtracker.dto.JobRequest;
import com.arikaran.jobtracker.entity.Job;
import com.arikaran.jobtracker.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public Job createJob(@RequestBody JobRequest request) {
        return jobService.createJob(request);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id,
                         @RequestBody JobRequest request) {
        return jobService.updateJob(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "Job deleted successfully";
    }
}