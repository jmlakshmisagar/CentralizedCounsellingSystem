package com.ccs.dto.response;

import com.ccs.enums.CandidateStatus;
import com.ccs.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateResponse {

    private Long id;

    private Long applicationNumber;

    private String candidateName;

    private Integer rank;

    private Gender gender;

    private Long reservationCategoryId;

    private String reservationCategoryCode;

    private Long courseId;

    private String courseCode;

    private String mobileNumber;

    private String email;

    private CandidateStatus status;

}