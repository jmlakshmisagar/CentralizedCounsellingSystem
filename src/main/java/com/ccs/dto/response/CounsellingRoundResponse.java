package com.ccs.dto.response;

import com.ccs.enums.RoundStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CounsellingRoundResponse {

    private Long id;

    private Long counsellingSessionId;

    private String sessionName;

    private Integer roundNumber;

    private String roundName;

    private LocalDate startDate;

    private LocalDate endDate;

    private RoundStatus status;

}