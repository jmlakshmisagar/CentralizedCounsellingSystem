package com.ccs.csv.candidate;

import org.springframework.stereotype.Component;

@Component
public class CandidateCsvValidator {

    public void validate(CandidateCsvDto dto) {

        if (dto.getApplicationNumber() == null) {
            throw new IllegalArgumentException("Application Number is required");
        }

        if (dto.getCandidateName() == null || dto.getCandidateName().isBlank()) {
            throw new IllegalArgumentException("Candidate Name is required");
        }

        if (dto.getRank() == null || dto.getRank() <= 0) {
            throw new IllegalArgumentException("Invalid Rank");
        }

    }

}