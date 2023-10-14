package com.wanted.wanted.jobposting.service;

import com.wanted.wanted.applicant.entity.Applicant;
import com.wanted.wanted.applicant.repository.ApplicantRepository;
import com.wanted.wanted.company.entity.Company;
import com.wanted.wanted.jobposting.dto.JobPostingDto;
import com.wanted.wanted.jobposting.entity.ApplyForJob;
import com.wanted.wanted.jobposting.entity.JobPosting;
import com.wanted.wanted.jobposting.repository.ApplyForJobRepository;
import com.wanted.wanted.jobposting.repository.JobPostingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class JobPostingServiceTest {

    @Autowired
    private JobPostingService jobPostingService;

    @MockBean
    private JobPostingRepository jobPostingRepository;

    @MockBean
    private ApplicantRepository applicantRepository;

    @MockBean
    private ApplyForJobRepository applyForJobRepository;

    @Test
    @DisplayName("JobPosting 생성")
    public void testCreateJobPosting() {
        // given
        Long posting_id = 1L;
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
        jobPosting.setPosting_id(posting_id);
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
        JobPostingDto.PostAndUpdateResponse result = jobPostingService.createJobPosting(jobPostingDto);

        // then
        assertThat(result.getPosting_id()).isEqualTo(posting_id);
        assertThat(result.getCompany_id()).isEqualTo(company_id);
        assertThat(result.getCompany_name()).isEqualTo(company_name);
        assertThat(result.getCountry()).isEqualTo(country);
        assertThat(result.getLocation()).isEqualTo(location);
        assertThat(result.getPosition()).isEqualTo(position);
        assertThat(result.getReward()).isEqualTo(reward);
        assertThat(result.getDescription()).isEqualTo(description);
        assertThat(result.getSkill()).isEqualTo(skill);
    }

    @Test
    @DisplayName("JobPosting 수정")
    public void testUpdateJobPosting() {
        // given
        Long posting_id = 1L;
        String position = "백엔드 주니어 개발자";
        Integer reward = 1000000;
        String description = "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String skill = "Python";
        Long company_id = 1L;
        String company_name = "원티드랩";
        String country = "한국";
        String location = "서울";

        Integer updateReward = 1500000;
        String updateSkill = "Django";

        JobPostingDto.Update jobPostingDto = new JobPostingDto.Update();
        jobPostingDto.setPosition(position);
        jobPostingDto.setReward(updateReward);
        jobPostingDto.setDescription(description);
        jobPostingDto.setSkill(updateSkill);

        JobPosting jobPosting = new JobPosting();
        jobPosting.setPosting_id(posting_id);
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

        Mockito.when(jobPostingRepository.findById(anyLong())).thenReturn(Optional.of(jobPosting));

        // when
        JobPostingDto.PostAndUpdateResponse result = jobPostingService.updateJobPosting(posting_id ,jobPostingDto);

        // then
        assertThat(result.getPosting_id()).isEqualTo(posting_id);
        assertThat(result.getCompany_id()).isEqualTo(company_id);
        assertThat(result.getCompany_name()).isEqualTo(company_name);
        assertThat(result.getCountry()).isEqualTo(country);
        assertThat(result.getLocation()).isEqualTo(location);
        assertThat(result.getPosition()).isEqualTo(position);
        assertThat(result.getReward()).isEqualTo(updateReward);
        assertThat(result.getDescription()).isEqualTo(description);
        assertThat(result.getSkill()).isEqualTo(updateSkill);
    }

    @Test
    @DisplayName("JobPosting 삭제")
    public void testDeleteJobPosting() {
        Long posting_id = 1L;

        Mockito.doNothing().when(jobPostingRepository).deleteById(posting_id);

        // when
        jobPostingService.deleteJobPosting(posting_id);

        // then
        Mockito.verify(jobPostingRepository).deleteById(posting_id);
    }

    @Test
    @DisplayName("JobPosting 조회")
    public void testGetJobPosting() {
        // given
        Long posting_id = 1L;
        String position = "백엔드 주니어 개발자";
        Integer reward = 1000000;
        String description = "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String skill = "Python";
        Long company_id = 1L;
        String company_name = "원티드랩";
        String country = "한국";
        String location = "서울";

        JobPosting jobPosting = new JobPosting();
        jobPosting.setPosting_id(posting_id);
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

        Mockito.when(jobPostingRepository.findAll()).thenReturn(List.of(jobPosting));

        // when
        List<JobPostingDto.GetResponse> jobPostingList = jobPostingService.getJobPostings();

        // then
        assertThat(jobPostingList.get(0).getPosting_id()).isEqualTo(posting_id);
        assertThat(jobPostingList.get(0).getCompany_name()).isEqualTo(company_name);
        assertThat(jobPostingList.get(0).getCountry()).isEqualTo(country);
        assertThat(jobPostingList.get(0).getLocation()).isEqualTo(location);
        assertThat(jobPostingList.get(0).getPosition()).isEqualTo(position);
        assertThat(jobPostingList.get(0).getReward()).isEqualTo(reward);
        assertThat(jobPostingList.get(0).getSkill()).isEqualTo(skill);
    }

    @Test
    @DisplayName("JobPosting 검색어 조회")
    public void testGetSearchJobPosting() {
        // given
        Long posting_id = 1L;
        String position = "백엔드 주니어 개발자";
        Integer reward = 1000000;
        String description = "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String skill = "Python";
        Long company_id = 1L;
        String company_name = "원티드랩";
        String country = "한국";
        String location = "서울";

        JobPosting jobPosting = new JobPosting();
        jobPosting.setPosting_id(posting_id);
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

        Mockito.when(jobPostingRepository.searchJobPostings(anyString())).thenReturn(List.of(jobPosting));

        // when
        List<JobPostingDto.GetResponse> jobPostingList = jobPostingService.getSearchJobPostings("서울");

        // then
        assertThat(jobPostingList.get(0).getPosting_id()).isEqualTo(posting_id);
        assertThat(jobPostingList.get(0).getCompany_name()).isEqualTo(company_name);
        assertThat(jobPostingList.get(0).getCountry()).isEqualTo(country);
        assertThat(jobPostingList.get(0).getLocation()).isEqualTo(location);
        assertThat(jobPostingList.get(0).getPosition()).isEqualTo(position);
        assertThat(jobPostingList.get(0).getReward()).isEqualTo(reward);
        assertThat(jobPostingList.get(0).getSkill()).isEqualTo(skill);
    }

    @Test
    @DisplayName("JobPosting 상세 조회")
    public void testGetDetailJobPosting() {
        // given
        Long posting_id = 1L;
        String position = "백엔드 주니어 개발자";
        Integer reward = 1000000;
        String description = "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String skill = "Python";
        Long company_id = 1L;
        String company_name = "원티드랩";
        String country = "한국";
        String location = "서울";

        JobPosting jobPosting1 = new JobPosting();
        jobPosting1.setPosting_id(posting_id);
        jobPosting1.setPosition(position);
        jobPosting1.setReward(reward);
        jobPosting1.setDescription(description);
        jobPosting1.setSkill(skill);

        JobPosting jobPosting2 = new JobPosting();
        jobPosting2.setPosting_id(2L);

        Company company = new Company();
        company.setCompany_id(company_id);
        company.setCompany_name(company_name);
        company.setCountry(country);
        company.setLocation(location);
        company.setJobPostingList(List.of(jobPosting2));

        jobPosting1.setCompany(company);

        Mockito.when(jobPostingRepository.findById(anyLong())).thenReturn(Optional.of(jobPosting1));

        // when
        JobPostingDto.DetailResponse detailJobPosting = jobPostingService.getDetailJobPosting(1L);

        // then
        assertThat(detailJobPosting.getPosting_id()).isEqualTo(posting_id);
        assertThat(detailJobPosting.getCompany_name()).isEqualTo(company_name);
        assertThat(detailJobPosting.getCountry()).isEqualTo(country);
        assertThat(detailJobPosting.getLocation()).isEqualTo(location);
        assertThat(detailJobPosting.getPosition()).isEqualTo(position);
        assertThat(detailJobPosting.getReward()).isEqualTo(reward);
        assertThat(detailJobPosting.getSkill()).isEqualTo(skill);
        assertThat(detailJobPosting.getDescription()).isEqualTo(description);
        assertThat(detailJobPosting.getOtherJobPostingList()).isEqualTo(List.of(2L));
    }

    @Test
    @DisplayName("JobPosting 상세 조회")
    public void testApplyForJob() {
        // given
        Long posting_id = 1L;
        Long applicant_id = 1L;

        JobPosting jobPosting = new JobPosting();
        jobPosting.setPosting_id(posting_id);

        Applicant applicant = new Applicant();
        applicant.setApplicant_id(applicant_id);

        ApplyForJob applyForJob = new ApplyForJob();
        applyForJob.setJobPosting(jobPosting);
        applyForJob.setApplicant(applicant);

        Mockito.when(jobPostingRepository.findById(anyLong())).thenReturn(Optional.of(jobPosting));
        Mockito.when(applicantRepository.findById(anyLong())).thenReturn(Optional.of(applicant));
        Mockito.when(applyForJobRepository.save(Mockito.any(ApplyForJob.class))).thenReturn(applyForJob);

        // when
        JobPostingDto.ApplyResponse applyResponse = jobPostingService.applyForJob(posting_id, applicant_id);

        // then
        assertThat(applyResponse.getPosting_id()).isEqualTo(posting_id);
        assertThat(applyResponse.getApplicant_id()).isEqualTo(applicant_id);
    }
}