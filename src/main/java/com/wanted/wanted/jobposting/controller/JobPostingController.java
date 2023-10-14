package com.wanted.wanted.jobposting.controller;

import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.service.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{position_id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long position_id) {
        jobPostingService.deleteJobPosting(position_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<JobPostingDto.GetResponse>> getJobPostings() {
        return new ResponseEntity<>(jobPostingService.getJobPostings(), HttpStatus.OK);
    }

    @GetMapping("/url")
    public ResponseEntity<List<JobPostingDto.GetResponse>> getSearchJobPostings(@RequestParam String search) {
        return new ResponseEntity<>(jobPostingService.getSearchJobPostings(search), HttpStatus.OK);
    }
}
