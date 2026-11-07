package com.arikaran.jobtracker.service;

import com.arikaran.jobtracker.dto.JobRequest;
import com.arikaran.jobtracker.entity.*;
import com.arikaran.jobtracker.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public JobService(JobRepository jobRepository,
                      UserRepository userRepository,
                      CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public Job createJob(JobRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Company company = companyRepository.findById(request.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Job job = new Job();
        job.setUser(user);
        job.setCompany(company);
        job.setJobTitle(request.jobTitle());
        job.setAppliedDate(request.appliedDate());

        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public Job updateJob(Long id, JobRequest request) {
        Job job = getJobById(id);

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Company company = companyRepository.findById(request.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        job.setUser(user);
        job.setCompany(company);
        job.setJobTitle(request.jobTitle());
        job.setAppliedDate(request.appliedDate());

        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.delete(getJobById(id));
    }
}