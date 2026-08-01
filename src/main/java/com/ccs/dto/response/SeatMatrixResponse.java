package com.ccs.dto.response;

import com.ccs.enums.SeatMatrixStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatMatrixResponse {

    private Long id;

    private Long collegeCourseId;

    private String collegeCode;

    private String collegeName;

    private String courseCode;

    private String courseName;

    private String reservationCategoryCode;

    private Integer totalSeats;

    private Integer filledSeats;

    private Integer availableSeats;

    private SeatMatrixStatus status;

}