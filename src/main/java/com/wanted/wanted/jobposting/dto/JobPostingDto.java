package com.wanted.wanted.jobposting.dto;

import lombok.*;

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
    @Builder
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
}
