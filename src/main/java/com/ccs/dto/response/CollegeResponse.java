package com.ccs.dto.response;

import com.ccs.enums.CollegeStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollegeResponse {

    private Long id;

    private String collegeCode;

    private String collegeName;

    private String city;

    private String district;

    private CollegeStatus status;

}