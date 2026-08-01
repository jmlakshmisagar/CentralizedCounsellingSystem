package com.ccs.dto.request;

import com.ccs.enums.ReservationCategoryStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationCategoryRequest {

    @NotBlank
    @Size(max = 10)
    private String categoryCode;

    @NotBlank
    @Size(max = 100)
    private String categoryName;

    @NotNull
    private ReservationCategoryStatus status;

}