package com.ccs.dto.response;

import com.ccs.enums.AdmissionStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AdmissionResponse {

    private Long id;

    private Long candidateId;
    private String candidateName;

    private Integer allottedRank;

    private Long counsellingRoundId;
    private String roundName;

    private Long collegeId;
    private String collegeCode;
    private String collegeName;

    private Long courseId;
    private String courseCode;
    private String courseName;

    private String reservationCategoryCode;

    private AdmissionStatus status;

    private LocalDateTime allottedAt;

}