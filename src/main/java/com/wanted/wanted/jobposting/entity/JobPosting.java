package com.wanted.wanted.jobposting.entity;

import com.wanted.wanted.company.entity.Company;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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

//    public void setCompany(Company company) {
//        this.company = company;
//        if(!company.getJobPostingList().contains(this)) {
//            company.getJobPostingList().add(this);
//        }
//    }
}
