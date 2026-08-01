package com.ccs.csv.college;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollegeCsvDto {

    private String collegeCode;

    private String collegeName;

    private String city;

    private String district;

    private String status;

}