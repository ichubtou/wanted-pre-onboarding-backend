package com.wanted.wanted.jobposting.mapper;

import com.wanted.wanted.company.entity.Company;
import com.wanted.wanted.company.service.CompanyService;
import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.entity.JobPosting;
import com.wanted.wanted.jobposting.repository.JobPostingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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

    public JobPostingDto.PostResponse jobPostingToJobPostingPostResponse(JobPosting jobPosting) {
        JobPostingDto.PostResponse postResponse = new JobPostingDto.PostResponse();
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
}
