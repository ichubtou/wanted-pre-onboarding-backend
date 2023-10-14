package com.wanted.wanted.jobposting.service;

import com.wanted.wanted.applicant.entity.Applicant;
import com.wanted.wanted.applicant.repository.ApplicantRepository;
import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.entity.ApplyForJob;
import com.wanted.wanted.jobposting.entity.JobPosting;
import com.wanted.wanted.jobposting.mapper.JobPostingMapper;
import com.wanted.wanted.jobposting.repository.ApplyForJobRepository;
import com.wanted.wanted.jobposting.repository.JobPostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;
    private final ApplicantRepository applicantRepository;
    private final ApplyForJobRepository applyForJobRepository;
    private final JobPostingMapper jobPostingMapper;

    public JobPostingDto.PostAndUpdateResponse createJobPosting(JobPostingDto.Post jobPostingDto) {
        JobPosting jobPosting = jobPostingMapper.jobPostingPostToJobPosting(jobPostingDto);

        JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);

        JobPostingDto.PostAndUpdateResponse jobPostingPostResponse = jobPostingMapper.jobPostingToJobPostingPostResponse(savedJobPosting);

        return jobPostingPostResponse;
    }

    public JobPostingDto.PostAndUpdateResponse updateJobPosting(Long position_id, JobPostingDto.Update jobPostingDto) {
        JobPosting jobPosting = jobPostingRepository.findById(position_id).get();
        Optional.ofNullable(jobPostingDto.getPosition()).ifPresent(jobPosting::setPosition);
        Optional.ofNullable(jobPostingDto.getReward()).ifPresent(jobPosting::setReward);
        Optional.ofNullable(jobPostingDto.getDescription()).ifPresent(jobPosting::setDescription);
        Optional.ofNullable(jobPostingDto.getSkill()).ifPresent(jobPosting::setSkill);

        JobPostingDto.PostAndUpdateResponse jobPostingUpdateResponse = jobPostingMapper.jobPostingToJobPostingPostResponse(jobPosting);

        return jobPostingUpdateResponse;
    }

    public void deleteJobPosting(Long posting_id) {
        jobPostingRepository.deleteById(posting_id);
    }

    public List<JobPostingDto.GetResponse> getJobPostings() {
        List<JobPosting> jobPostingList = jobPostingRepository.findAll();

        List<JobPostingDto.GetResponse> getResponseList = jobPostingMapper.jobPostingGetListToJobPostingList(jobPostingList);

        return getResponseList;
    }

    public List<JobPostingDto.GetResponse> getSearchJobPostings(String search) {
        return jobPostingMapper.jobPostingGetListToJobPostingList(jobPostingRepository.searchJobPostings(search));
    }

    public JobPostingDto.DetailResponse getDetailJobPosting(Long position_id) {
        return jobPostingMapper.jobPostingToDetailJobPostingResponse(jobPostingRepository.findById(position_id).get());
    }

    public JobPostingDto.applyResponse applyForJob(Long posting_id, Long applicant_id) {
        JobPosting jobPosting = jobPostingRepository.findById(posting_id).get();
        Applicant applicant = applicantRepository.findById(applicant_id).get();

        List<ApplyForJob> applyForJobList = jobPosting.getApplyForJobList();
        for (ApplyForJob applyForJob : applyForJobList) {
            if (applyForJob.getApplicant().equals(applicant)) {
                throw new RuntimeException();
            }
        }

        ApplyForJob applyForJob = new ApplyForJob();

        applyForJob.setJobPosting(jobPosting);
        applyForJob.setApplicant(applicant);

        ApplyForJob savedApplyForJob = applyForJobRepository.save(applyForJob);

        return jobPostingMapper.applyForJobToApplyResponse(savedApplyForJob);
    }
}
