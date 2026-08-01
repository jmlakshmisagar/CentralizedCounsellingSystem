package com.ccs.csv.parser;

import com.ccs.csv.dto.CourseCsvDto;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseCsvParser {

    public List<CourseCsvDto> parse(MultipartFile file)
            throws IOException, CsvValidationException {

        List<CourseCsvDto> courses = new ArrayList<>();

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(file.getInputStream()))) {

            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {

                courses.add(
                        CourseCsvDto.builder()
                                .courseCode(row[0].trim())
                                .courseName(row[1].trim())
                                .duration(Integer.parseInt(row[2].trim()))
                                .status(row[3].trim())
                                .build()
                );
            }
        }

        return courses;
    }

}