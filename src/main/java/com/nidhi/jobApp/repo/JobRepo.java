package com.nidhi.jobApp.repo;

import com.nidhi.jobApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(

            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),


            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),


            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),


            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));

    //method to add job
    public void addJob(JobPost newJob){
        jobs.add(newJob);
        //System.out.println(jobs);
    }

    //view all jobs page k liye
    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public JobPost getJob(int postId) {
        for( JobPost job : jobs){
            if( job.getPostId() == postId){
                return job;
            }
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for( JobPost jb : jobs){
            if( jb.getPostId() == jobPost.getPostId()){
                jb.setPostProfile( jobPost.getPostProfile());
                jb.setPostDesc( jobPost.getPostDesc());
                jb.setReqExperience( jobPost.getReqExperience());
                jb.setPostTechStack( jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob( int jobId) {
        for( JobPost j1 : jobs ){
            if(j1.getPostId() == jobId){
                jobs.remove(j1);
            }
        }
        //can be done like
        //jobs.removeIf(j1 -> j1.getPostId() == jobId);
    }
}
