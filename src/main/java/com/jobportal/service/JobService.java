package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.repository.JobRepository;
import com.jobportal.entity.Job;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepo;

    public Job addJob(Job job) {
        return jobRepo.save(job);
    }

    public List<Job> getJobs() {
        return jobRepo.findAll();
    }
}