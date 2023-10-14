package com.wanted.wanted.applicant.entity;

import com.wanted.wanted.jobposting.entity.ApplyForJob;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicant_id;

    @OneToMany(mappedBy = "applicant")
    private List<ApplyForJob> applyForJobList;
}
