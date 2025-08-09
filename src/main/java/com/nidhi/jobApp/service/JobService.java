package com.nidhi.jobApp.service;

import com.nidhi.jobApp.model.JobPost;

import com.nidhi.jobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    public void addJob(JobPost jobpost){
        repo.addJob( jobpost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();

    }
}
