package com.ccs.csv.candidate;

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
public class CandidateCsvDto {

    private Long applicationNumber;

    private String candidateName;

    private Integer rank;

    private String gender;

    private String reservationCategoryCode;

    private String courseCode;

    private String mobileNumber;

    private String email;

    private String status;

}