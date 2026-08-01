package com.ccs.csv.candidate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateCsvParser {

    public List<CandidateCsvDto> parse(MultipartFile file)
            throws IOException, CsvValidationException {

        List<CandidateCsvDto> candidates = new ArrayList<>();

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(file.getInputStream()))) {

            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {

                candidates.add(
                        CandidateCsvDto.builder()
                                .applicationNumber(Long.parseLong(row[0].trim()))
                                .candidateName(row[1].trim())
                                .rank(Integer.parseInt(row[2].trim()))
                                .gender(row[3].trim())
                                .reservationCategoryCode(row[4].trim())
                                .courseCode(row[5].trim())
                                .mobileNumber(row[6].trim())
                                .email(row[7].trim())
                                .status(row[8].trim())
                                .build()
                );
            }
        }

        return candidates;
    }

}