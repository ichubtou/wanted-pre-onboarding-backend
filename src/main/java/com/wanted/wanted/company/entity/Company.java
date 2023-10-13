package com.wanted.wanted.company.entity;

import com.wanted.wanted.jobposting.entity.JobPosting;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_id;

    @Column(nullable = false)
    private String company_name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "company")
    private List<JobPosting> jobPostingList;
}
