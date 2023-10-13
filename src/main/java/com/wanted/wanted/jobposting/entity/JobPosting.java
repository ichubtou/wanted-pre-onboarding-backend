package com.wanted.wanted.jobposting.entity;

import com.wanted.wanted.company.entity.Company;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posting_id;

    private String position;

    private Integer reward;

    private String skill;

    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "jobPosting")
    private List<ApplyForJob> applicantList;
}
