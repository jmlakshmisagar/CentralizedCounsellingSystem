package com.ccs.dto.request;

import com.ccs.enums.SeatMatrixStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatMatrixRequest {

    @NotNull
    private Long collegeCourseId;

    @NotNull
    private Long reservationCategoryId;

    @NotNull
    @Min(0)
    private Integer totalSeats;

    @NotNull
    @Min(0)
    private Integer filledSeats;

    @NotNull
    @Min(0)
    private Integer availableSeats;

    @NotNull
    private SeatMatrixStatus status;

}