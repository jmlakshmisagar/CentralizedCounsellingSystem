package com.ccs.csv.candidate;

import com.ccs.entity.Candidate;
import com.ccs.entity.Course;
import com.ccs.entity.ReservationCategory;
import com.ccs.enums.CandidateStatus;
import com.ccs.enums.Gender;
import com.ccs.repository.CandidateRepository;
import com.ccs.repository.CourseRepository;
import com.ccs.repository.ReservationCategoryRepository;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateImportService {

    private final CandidateCsvParser parser;
    private final CandidateCsvValidator validator;

    private final CandidateRepository candidateRepository;
    private final CourseRepository courseRepository;
    private final ReservationCategoryRepository reservationCategoryRepository;

    @Transactional
    public void importCandidates(MultipartFile file)
            throws IOException, CsvValidationException {

        List<CandidateCsvDto> csv = parser.parse(file);

        List<Candidate> candidates = new ArrayList<>();

        for (CandidateCsvDto dto : csv) {

            validator.validate(dto);

            if (candidateRepository.existsByApplicationNumber(dto.getApplicationNumber())) {
                continue;
            }

            Course course = courseRepository
                    .findByCourseCode(dto.getCourseCode())
                    .orElseThrow(() ->
                            new EntityNotFoundException(
                                    "Course not found : " + dto.getCourseCode()));

            ReservationCategory category =
                    reservationCategoryRepository
                            .findByCategoryCode(dto.getReservationCategoryCode())
                            .orElseThrow(() ->
                                    new EntityNotFoundException(
                                            "Category not found : " +
                                                    dto.getReservationCategoryCode()));

            Candidate candidate = Candidate.builder()
                    .applicationNumber(dto.getApplicationNumber())
                    .candidateName(dto.getCandidateName())
                    .rank(dto.getRank())
                    .gender(Gender.valueOf(dto.getGender()))
                    .reservationCategory(category)
                    .course(course)
                    .mobileNumber(dto.getMobileNumber())
                    .email(dto.getEmail())
                    .status(CandidateStatus.valueOf(dto.getStatus()))
                    .build();

            candidates.add(candidate);
        }

        candidateRepository.saveAll(candidates);

    }

}