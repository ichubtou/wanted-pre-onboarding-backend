package com.wanted.wanted.jobposting.controller;

import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.service.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobposting")
@RequiredArgsConstructor
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @PostMapping
    public ResponseEntity<JobPostingDto.PostAndUpdateResponse> createJobPosting(@RequestBody JobPostingDto.Post jobPostingPostDto) {
        return new ResponseEntity<>(jobPostingService.createJobPosting(jobPostingPostDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{position_id}")
    public ResponseEntity<JobPostingDto.PostAndUpdateResponse> updateJobPosting(@PathVariable Long position_id, @RequestBody JobPostingDto.Update jobPostingUpdateDto) {
        return new ResponseEntity<>(jobPostingService.updateJobPosting(position_id, jobPostingUpdateDto), HttpStatus.OK);
    }
}
