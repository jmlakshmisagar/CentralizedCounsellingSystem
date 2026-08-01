package com.ccs.dto.response;

import com.ccs.enums.CandidatePreferenceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidatePreferenceResponse {

    private Long id;

    private Long candidateId;
    private String candidateName;

    private Long collegeId;
    private String collegeCode;
    private String collegeName;

    private Long courseId;
    private String courseCode;
    private String courseName;

    private Integer preferenceOrder;

    private CandidatePreferenceStatus status;

}