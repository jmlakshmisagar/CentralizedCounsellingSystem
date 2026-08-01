package com.ccs.dto.response;

import com.ccs.enums.CourseStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {

    private Long id;

    private String courseCode;

    private String courseName;

    private Integer duration;

    private CourseStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}