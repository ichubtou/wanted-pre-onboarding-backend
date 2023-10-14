package com.wanted.wanted.jobposting.service;

import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.entity.JobPosting;
import com.wanted.wanted.jobposting.mapper.JobPostingMapper;
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
    private final JobPostingMapper jobPostingMapper;

    public JobPostingDto.PostAndUpdateResponse createJobPosting(JobPostingDto.Post jobPostingDto) {
        JobPosting jobPosting = jobPostingMapper.jobPostingPostToJobPosting(jobPostingDto);

        JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);

        JobPostingDto.PostAndUpdateResponse jobPostingPostResponse = jobPostingMapper.jobPostingToJobPostingPostResponse(savedJobPosting);

        return jobPostingPostResponse;
    }

    public JobPostingDto.PostAndUpdateResponse updateJobPosting(Long position_id, JobPostingDto.Update jobPostingDto) {
        Optional<JobPosting> findJobPosting = jobPostingRepository.findById(position_id);
        JobPosting jobPosting = findJobPosting.get();
        Optional.ofNullable(jobPostingDto.getPosition()).ifPresent(jobPosting::setPosition);
        Optional.ofNullable(jobPostingDto.getReward()).ifPresent(jobPosting::setReward);
        Optional.ofNullable(jobPostingDto.getDescription()).ifPresent(jobPosting::setDescription);
        Optional.ofNullable(jobPostingDto.getSkill()).ifPresent(jobPosting::setSkill);

        JobPostingDto.PostAndUpdateResponse jobPostingUpdateResponse = jobPostingMapper.jobPostingToJobPostingPostResponse(jobPosting);

        return jobPostingUpdateResponse;
    }

    public void deleteJobPosting(Long position_id) {
        jobPostingRepository.deleteById(position_id);
    }

    public List<JobPostingDto.GetResponse> getJobPostings() {
        List<JobPosting> jobPostingList = jobPostingRepository.findAll();

        List<JobPostingDto.GetResponse> getResponseList = jobPostingMapper.jobPostingGetListToJobPostingList(jobPostingList);

        return getResponseList;
    }

    public List<JobPostingDto.GetResponse> getSearchJobPostings(String search) {
        return jobPostingMapper.jobPostingGetListToJobPostingList(jobPostingRepository.searchJobPostings(search));
    }
}
