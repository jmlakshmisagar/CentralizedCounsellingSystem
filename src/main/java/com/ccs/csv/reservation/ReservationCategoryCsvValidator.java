package com.ccs.csv.reservation;

import org.springframework.stereotype.Component;

@Component
public class ReservationCategoryCsvValidator {

    public void validate(ReservationCategoryCsvDto dto) {

        if (dto.getCategoryCode() == null || dto.getCategoryCode().isBlank()) {
            throw new IllegalArgumentException("Category Code is required");
        }

        if (dto.getCategoryName() == null || dto.getCategoryName().isBlank()) {
            throw new IllegalArgumentException("Category Name is required");
        }

        if (dto.getStatus() == null || dto.getStatus().isBlank()) {
            throw new IllegalArgumentException("Status is required");
        }

    }
}