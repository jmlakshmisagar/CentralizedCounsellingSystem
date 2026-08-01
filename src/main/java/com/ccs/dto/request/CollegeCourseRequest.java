package com.ccs.dto.request;

import com.ccs.enums.CollegeCourseStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollegeCourseRequest {

    @NotNull
    private Long collegeId;

    @NotNull
    private Long courseId;

    @NotNull
    @Min(1)
    private Integer intake;

    @NotNull
    private CollegeCourseStatus status;

}