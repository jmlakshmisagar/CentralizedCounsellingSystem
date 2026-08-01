package com.ccs.csv.reservation;

import com.ccs.entity.ReservationCategory;
import com.ccs.enums.ReservationCategoryStatus;
import com.ccs.repository.ReservationCategoryRepository;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationCategoryImportService {

    private final ReservationCategoryCsvParser parser;

    private final ReservationCategoryCsvValidator validator;

    private final ReservationCategoryRepository repository;

    public void importCategories(MultipartFile file)
            throws IOException, CsvValidationException {

        List<ReservationCategoryCsvDto> csvData = parser.parse(file);

        List<ReservationCategory> categories = new ArrayList<>();

        for (ReservationCategoryCsvDto dto : csvData) {

            validator.validate(dto);

            ReservationCategory category =
                    ReservationCategory.builder()
                            .categoryCode(dto.getCategoryCode())
                            .categoryName(dto.getCategoryName())
                            .status(
                                    ReservationCategoryStatus.valueOf(
                                            dto.getStatus().toUpperCase()
                                    )
                            )
                            .build();

            categories.add(category);
        }

        repository.saveAll(categories);
    }

}