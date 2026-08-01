package com.ccs.dto.request;

import com.ccs.enums.RoundStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CounsellingRoundRequest {

    @NotNull
    private Long counsellingSessionId;

    @NotNull
    private Integer roundNumber;

    @NotBlank
    private String roundName;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private RoundStatus status;

}