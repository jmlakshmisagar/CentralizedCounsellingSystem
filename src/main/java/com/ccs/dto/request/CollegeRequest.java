package com.ccs.dto.request;

import com.ccs.enums.CollegeStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollegeRequest {

    @NotBlank
    @Size(max = 20)
    private String collegeCode;

    @NotBlank
    @Size(max = 250)
    private String collegeName;

    @NotBlank
    @Size(max = 100)
    private String city;

    @NotBlank
    @Size(max = 100)
    private String district;

    @NotNull
    private CollegeStatus status;

}