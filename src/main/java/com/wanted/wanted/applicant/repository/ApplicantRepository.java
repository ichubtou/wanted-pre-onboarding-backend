package com.wanted.wanted.applicant.repository;

import com.wanted.wanted.applicant.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
