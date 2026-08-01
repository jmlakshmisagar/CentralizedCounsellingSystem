package com.ccs.csv.college;

import org.springframework.stereotype.Component;

@Component
public class CollegeCsvValidator {

    public void validate(CollegeCsvDto dto) {

        if (dto.getCollegeCode() == null || dto.getCollegeCode().isBlank()) {
            throw new IllegalArgumentException("College Code is required");
        }

        if (dto.getCollegeName() == null || dto.getCollegeName().isBlank()) {
            throw new IllegalArgumentException("College Name is required");
        }

        if (dto.getCity() == null || dto.getCity().isBlank()) {
            throw new IllegalArgumentException("City is required");
        }

        if (dto.getDistrict() == null || dto.getDistrict().isBlank()) {
            throw new IllegalArgumentException("District is required");
        }

        if (dto.getStatus() == null || dto.getStatus().isBlank()) {
            throw new IllegalArgumentException("Status is required");
        }

    }

}