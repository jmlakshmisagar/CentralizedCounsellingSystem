package com.ccs.allocation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllocationResult {

    private Long candidateId;

    private String candidateName;

    private Integer rank;

    private Long collegeId;

    private String collegeCode;

    private String collegeName;

    private Long courseId;

    private String courseCode;

    private String courseName;

    private String reservationCategory;

    private Integer allottedPreference;

    private boolean allocated;

    private String message;

}