package com.ccs.dto.request;

import com.ccs.enums.CandidateStatus;
import com.ccs.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateRequest {

    @NotNull
    private Long applicationNumber;

    @NotBlank
    private String candidateName;

    @NotNull
    @Min(1)
    private Integer rank;

    @NotNull
    private Gender gender;

    @NotNull
    private Long reservationCategoryId;

    @NotNull
    private Long courseId;

    @NotBlank
    private String mobileNumber;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private CandidateStatus status;

}