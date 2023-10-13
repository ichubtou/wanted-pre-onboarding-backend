package com.wanted.wanted.jobposting.service;

import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.entity.JobPosting;
import com.wanted.wanted.jobposting.mapper.JobPostingMapper;
import com.wanted.wanted.jobposting.repository.JobPostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;
    private final JobPostingMapper jobPostingMapper;

    public JobPostingDto.PostResponse createJobPosting(JobPostingDto.Post jobPostingDto) {
        JobPosting jobPosting = jobPostingMapper.jobPostingPostToJobPosting(jobPostingDto);

        JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);

        JobPostingDto.PostResponse jobPostingPostResponse = jobPostingMapper.jobPostingToJobPostingPostResponse(savedJobPosting);

        return jobPostingPostResponse;
    }
}
