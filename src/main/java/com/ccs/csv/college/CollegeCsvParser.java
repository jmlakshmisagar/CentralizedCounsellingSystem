package com.ccs.csv.college;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CollegeCsvParser {

    public List<CollegeCsvDto> parse(MultipartFile file)
            throws IOException, CsvValidationException {

        List<CollegeCsvDto> colleges = new ArrayList<>();

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(file.getInputStream()))) {

            // Skip Header
            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {

                colleges.add(
                        CollegeCsvDto.builder()
                                .collegeCode(row[0].trim())
                                .collegeName(row[1].trim())
                                .city(row[2].trim())
                                .district(row[3].trim())
                                .status(row[4].trim())
                                .build()
                );
            }
        }

        return colleges;
    }

}