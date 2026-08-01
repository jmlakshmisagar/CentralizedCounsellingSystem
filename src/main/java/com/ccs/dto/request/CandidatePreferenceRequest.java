package com.ccs.dto.request;

import com.ccs.enums.CandidatePreferenceStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidatePreferenceRequest {

    @NotNull
    private Long candidateId;

    @NotNull
    private Long collegeId;

    @NotNull
    private Long courseId;

    @NotNull
    @Min(1)
    private Integer preferenceOrder;

    @NotNull
    private CandidatePreferenceStatus status;

}