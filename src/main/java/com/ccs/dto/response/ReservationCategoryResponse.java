package com.ccs.dto.response;

import com.ccs.enums.ReservationCategoryStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationCategoryResponse {

    private Long id;

    private String categoryCode;

    private String categoryName;

    private ReservationCategoryStatus status;

}