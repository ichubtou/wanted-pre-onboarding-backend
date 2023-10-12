package com.wanted.wanted.jobposting.entity;

import com.wanted.wanted.company.entity.Company;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posting_id;

    private String Position;

    private String reward;

    private String skill;

    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "jobPosting")
    private List<ApplyForJob> applicantList;
}
