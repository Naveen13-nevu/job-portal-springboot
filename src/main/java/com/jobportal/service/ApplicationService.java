package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.*;
import com.jobportal.repository.*;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository appRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JobRepository jobRepo;

    public Application apply(Long userId, Long jobId) {

        User user = userRepo.findById(userId).orElseThrow();
        Job job = jobRepo.findById(jobId).orElseThrow();

        Application app = new Application();
        app.setUser(user);
        app.setJob(job);
        app.setStatus("APPLIED");

        return appRepo.save(app);
    }

    public List<Application> getUserApplications(Long userId) {
        return appRepo.findByUserId(userId);
    }
}