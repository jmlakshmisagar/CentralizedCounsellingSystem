package com.ccs.dto.request;

import com.ccs.enums.CourseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {

    @NotBlank
    @Size(max = 20)
    private String courseCode;

    @NotBlank
    @Size(max = 100)
    private String courseName;

    @NotNull
    @Positive
    private Integer duration;

    @NotNull
    private CourseStatus status;
}