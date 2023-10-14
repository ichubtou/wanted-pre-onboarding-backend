package com.wanted.wanted.jobposting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class JobPostingDto {
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private Long company_id;
        private String position;
        private Integer reward;
        private String description;
        private String skill;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private String position;
        private Integer reward;
        private String description;
        private String skill;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostAndUpdateResponse {
        private Long posting_id;
        private Long company_id;
        private String company_name;
        private String country;
        private String location;
        private String position;
        private Integer reward;
        private String description;
        private String skill;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetResponse {
        private Long posting_id;
        private String company_name;
        private String country;
        private String location;
        private String position;
        private Integer reward;
        private String skill;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailResponse {
        private Long posting_id;
        private String company_name;
        private String country;
        private String location;
        private String position;
        private Integer reward;
        private String skill;
        private String description;
        private List<Long> otherJobPostingList;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ApplyResponse {
        private Long posting_id;
        private Long applicant_id;
    }
}
