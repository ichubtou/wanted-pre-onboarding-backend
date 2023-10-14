package com.wanted.wanted.jobposting.repository;

import com.wanted.wanted.jobposting.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    @Query("SELECT jp FROM JobPosting jp WHERE " +
            "(LOWER(jp.position) LIKE LOWER(concat('%', :search, '%')) " +
            "OR LOWER(jp.company.company_name) LIKE LOWER(concat('%', :search, '%')) " +
            "OR LOWER(jp.company.country) = LOWER(:search)) " +
            "OR LOWER(jp.company.location) = LOWER(:search) " +
            "OR LOWER(jp.skill) = LOWER(:search)")
    List<JobPosting> searchJobPostings(@Param("search") String search);
}
