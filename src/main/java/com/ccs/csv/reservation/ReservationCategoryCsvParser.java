package com.ccs.csv.reservation;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationCategoryCsvParser {

    public List<ReservationCategoryCsvDto> parse(MultipartFile file)
            throws IOException, CsvValidationException {

        List<ReservationCategoryCsvDto> categories = new ArrayList<>();

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(file.getInputStream()))) {

            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {

                categories.add(
                        ReservationCategoryCsvDto.builder()
                                .categoryCode(row[0].trim())
                                .categoryName(row[1].trim())
                                .status(row[2].trim())
                                .build()
                );
            }
        }

        return categories;
    }

}