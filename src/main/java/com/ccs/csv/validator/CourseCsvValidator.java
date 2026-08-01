package com.ccs.csv.validator;

import com.ccs.csv.dto.CourseCsvDto;
import org.springframework.stereotype.Component;

@Component
public class CourseCsvValidator {

    public void validate(CourseCsvDto dto) {

        if (dto.getCourseCode() == null || dto.getCourseCode().isBlank()) {
            throw new IllegalArgumentException("Course Code is required");
        }

        if (dto.getCourseName() == null || dto.getCourseName().isBlank()) {
            throw new IllegalArgumentException("Course Name is required");
        }

        if (dto.getDuration() == null || dto.getDuration() <= 0) {
            throw new IllegalArgumentException("Invalid Duration");
        }

        if (dto.getStatus() == null || dto.getStatus().isBlank()) {
            throw new IllegalArgumentException("Status is required");
        }

    }

}