package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.entity.Application;
import com.jobportal.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService appService;

    @PostMapping("/apply")
    public Application apply(@RequestParam Long userId, @RequestParam Long jobId) {
        return appService.apply(userId, jobId);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getUserApplications(@PathVariable Long userId) {
        return appService.getUserApplications(userId);
    }
}