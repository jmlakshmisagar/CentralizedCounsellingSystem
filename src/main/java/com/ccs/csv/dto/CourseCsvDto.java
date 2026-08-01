package com.ccs.csv.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseCsvDto {

    private String courseCode;

    private String courseName;

    private Integer duration;

    private String status;

}