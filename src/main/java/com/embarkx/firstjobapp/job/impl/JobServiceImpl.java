package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

//    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for(Job job:jobs){
//            if(job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()){
//            Job job = iterator.next();
//            if(job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id,Job updatedJob) {
//        for(Job job:jobs){
//            if(job.getId().equals(id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
//        return false;
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            if (updatedJob.getTitle() != null) {
                job.setTitle(updatedJob.getTitle());
            }
            
            if (updatedJob.getDescription() != null) {
                job.setDescription(updatedJob.getDescription());
            }
            
            if (updatedJob.getMinSalary() != null) {
                job.setMinSalary(updatedJob.getMinSalary());
            }
            
            if (updatedJob.getMaxSalary() != null) {
                job.setMaxSalary(updatedJob.getMaxSalary());
            }
            
            if (updatedJob.getLocation() != null) {
                job.setLocation(updatedJob.getLocation());
            }
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}