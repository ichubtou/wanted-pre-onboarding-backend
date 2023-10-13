package com.wanted.wanted.jobposting.service;

import com.wanted.wanted.company.entity.Company;
import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.entity.JobPosting;
import com.wanted.wanted.jobposting.mapper.JobPostingMapper;
import com.wanted.wanted.jobposting.repository.JobPostingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JobPostingServiceTest {

    @Autowired
    private JobPostingService jobPostingService;

    @MockBean
    private JobPostingRepository jobPostingRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("JobPosting 생성")
    public void testCreateJobPosting() {
        // given
        Long position_id = 1L;
        String position = "백엔드 주니어 개발자";
        Integer reward = 1000000;
        String description = "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String skill = "Python";
        Long company_id = 1L;
        String company_name = "원티드랩";
        String country = "한국";
        String location = "서울";

        JobPostingDto.Post jobPostingDto = new JobPostingDto.Post();
        jobPostingDto.setCompany_id(company_id);
        jobPostingDto.setPosition(position);
        jobPostingDto.setReward(reward);
        jobPostingDto.setDescription(description);
        jobPostingDto.setSkill(skill);

        JobPosting jobPosting = new JobPosting();
        jobPosting.setPosting_id(position_id);
        jobPosting.setPosition(position);
        jobPosting.setReward(reward);
        jobPosting.setDescription(description);
        jobPosting.setSkill(skill);

        Company company = new Company();
        company.setCompany_id(company_id);
        company.setCompany_name(company_name);
        company.setCountry(country);
        company.setLocation(location);

        jobPosting.setCompany(company);

        Mockito.when(jobPostingRepository.save(Mockito.any(JobPosting.class))).thenReturn(jobPosting);

        // when
        JobPostingDto.PostResponse result = jobPostingService.createJobPosting(jobPostingDto);

        // then
        assertThat(result.getCompany_id()).isEqualTo(company_id);
        assertThat(result.getCompany_name()).isEqualTo(company_name);
        assertThat(result.getCountry()).isEqualTo(country);
        assertThat(result.getLocation()).isEqualTo(location);
        assertThat(result.getPosition()).isEqualTo(position);
        assertThat(result.getReward()).isEqualTo(reward);
        assertThat(result.getDescription()).isEqualTo(description);
        assertThat(result.getSkill()).isEqualTo(skill);
    }
}