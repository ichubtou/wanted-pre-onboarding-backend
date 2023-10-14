package com.wanted.wanted.jobposting.mapper;

import com.wanted.wanted.company.service.CompanyService;
import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.entity.ApplyForJob;
import com.wanted.wanted.jobposting.entity.JobPosting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JobPostingMapper {
    private final CompanyService companyService;
    public JobPosting jobPostingPostToJobPosting(JobPostingDto.Post jobPostingDto) {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setPosition(jobPostingDto.getPosition());
        jobPosting.setReward(jobPostingDto.getReward());
        jobPosting.setDescription(jobPostingDto.getDescription());
        jobPosting.setSkill(jobPostingDto.getSkill());

        jobPosting.setCompany(companyService.getCompany(jobPostingDto.getCompany_id()));

        return jobPosting;
    }

    public JobPostingDto.PostAndUpdateResponse jobPostingToJobPostingPostResponse(JobPosting jobPosting) {
        JobPostingDto.PostAndUpdateResponse postResponse = new JobPostingDto.PostAndUpdateResponse();
        postResponse.setPosting_id(jobPosting.getPosting_id());
        postResponse.setCompany_id(jobPosting.getCompany().getCompany_id());
        postResponse.setCompany_name(jobPosting.getCompany().getCompany_name());
        postResponse.setCountry(jobPosting.getCompany().getCountry());
        postResponse.setLocation(jobPosting.getCompany().getLocation());
        postResponse.setPosition(jobPosting.getPosition());
        postResponse.setReward(jobPosting.getReward());
        postResponse.setSkill(jobPosting.getSkill());
        postResponse.setDescription(jobPosting.getDescription());

        return postResponse;
    }

    public List<JobPostingDto.GetResponse> jobPostingGetListToJobPostingList(List<JobPosting> jobPostingList) {
        List<JobPostingDto.GetResponse> getResponseList = new ArrayList<>();
        for (JobPosting jobPosting : jobPostingList) {
            JobPostingDto.GetResponse getResponse = new JobPostingDto.GetResponse();
            getResponse.setPosting_id(jobPosting.getPosting_id());
            getResponse.setCompany_name(jobPosting.getCompany().getCompany_name());
            getResponse.setCountry(jobPosting.getCompany().getCountry());
            getResponse.setLocation(jobPosting.getCompany().getLocation());
            getResponse.setPosition(jobPosting.getPosition());
            getResponse.setReward(jobPosting.getReward());
            getResponse.setSkill(jobPosting.getSkill());
            getResponseList.add(getResponse);
        }

        return getResponseList;
    }

    public JobPostingDto.DetailResponse jobPostingToDetailJobPostingResponse(JobPosting jobPosting) {
        JobPostingDto.DetailResponse detailResponse = new JobPostingDto.DetailResponse();
        detailResponse.setPosting_id(jobPosting.getPosting_id());
        detailResponse.setCompany_name(jobPosting.getCompany().getCompany_name());
        detailResponse.setCountry(jobPosting.getCompany().getCountry());
        detailResponse.setLocation(jobPosting.getCompany().getLocation());
        detailResponse.setPosition(jobPosting.getPosition());
        detailResponse.setReward(jobPosting.getReward());
        detailResponse.setSkill(jobPosting.getSkill());
        detailResponse.setDescription(jobPosting.getDescription());

        List<JobPosting> jobPostingList = jobPosting.getCompany().getJobPostingList();
        List<Long> otherJobPostingList = new ArrayList<>();
        for (JobPosting posting : jobPostingList) {
            otherJobPostingList.add(posting.getPosting_id());
        }

        detailResponse.setOtherJobPostingList(otherJobPostingList);

        return detailResponse;
    }

    public JobPostingDto.applyResponse applyForJobToApplyResponse(ApplyForJob applyForJob) {
        JobPostingDto.applyResponse applyResponse = new JobPostingDto.applyResponse();
        applyResponse.setPosting_id(applyForJob.getJobPosting().getPosting_id());
        applyResponse.setApplicant_id(applyForJob.getApplicant().getApplicant_id());

        return applyResponse;
    }
}
