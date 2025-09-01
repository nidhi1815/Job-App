package com.nidhi.jobApp.controller;

import com.nidhi.jobApp.model.JobPost;
import com.nidhi.jobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
public class JobRestController {

    @Autowired
    public JobService service;

    @GetMapping("jobPosts")
//    @ResponseBody
    //we are telling this method instead of jsp we are sending data
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
          return service.getJob( postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob( @RequestBody JobPost jobpost){
        service.addJob(jobpost);
        System.out.println("new job added");
        return service.getJob( jobpost.getPostId());
    }


    @PutMapping("jobPost")
    public JobPost updateJob( @RequestBody JobPost jobPost){
          service.updateJob( jobPost);
          return service.getJob( jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob( @PathVariable("postId") int JobId){
        service.deleteJob( JobId);
        return "Deleted";
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);

    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }
}
