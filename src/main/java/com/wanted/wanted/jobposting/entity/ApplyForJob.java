package com.wanted.wanted.jobposting.entity;

import com.wanted.wanted.applicant.entity.Applicant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ApplyForJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apply_id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "posting_id")
    private JobPosting jobPosting;
}
