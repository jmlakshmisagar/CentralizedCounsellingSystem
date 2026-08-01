package com.ccs.dto.response;

import com.ccs.enums.CollegeCourseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollegeCourseResponse {

    private Long id;

    private Long collegeId;

    private String collegeCode;

    private String collegeName;

    private Long courseId;

    private String courseCode;

    private String courseName;

    private Integer intake;

    private CollegeCourseStatus status;

}