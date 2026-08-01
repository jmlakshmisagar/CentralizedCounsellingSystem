package com.ccs.csv.college;

import com.ccs.entity.College;
import com.ccs.enums.CollegeStatus;
import com.ccs.repository.CollegeRepository;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollegeImportService {

    private final CollegeCsvParser parser;
    private final CollegeCsvValidator validator;
    private final CollegeRepository repository;

    @Transactional
    public void importColleges(MultipartFile file)
            throws IOException, CsvValidationException {

        List<CollegeCsvDto> csvData = parser.parse(file);

        List<College> colleges = new ArrayList<>();

        for (CollegeCsvDto dto : csvData) {

            validator.validate(dto);

            if (repository.existsByCollegeCode(dto.getCollegeCode())) {
                continue;
            }

            College college = College.builder()
                    .collegeCode(dto.getCollegeCode())
                    .collegeName(dto.getCollegeName())
                    .city(dto.getCity())
                    .district(dto.getDistrict())
                    .status(CollegeStatus.valueOf(dto.getStatus().toUpperCase()))
                    .build();

            colleges.add(college);
        }

        repository.saveAll(colleges);
    }

}