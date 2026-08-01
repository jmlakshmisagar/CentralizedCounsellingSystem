package com.ccs.csv.service;

import com.ccs.csv.dto.CourseCsvDto;
import com.ccs.csv.parser.CourseCsvParser;
import com.ccs.csv.validator.CourseCsvValidator;
import com.ccs.entity.Course;
import com.ccs.enums.CourseStatus;
import com.ccs.repository.CourseRepository;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseImportService {

    private final CourseCsvParser parser;

    private final CourseCsvValidator validator;

    private final CourseRepository repository;

    public void importCourses(MultipartFile file)
            throws IOException, CsvValidationException {

        List<CourseCsvDto> csvCourses = parser.parse(file);

        List<Course> courses = new ArrayList<>();

        for (CourseCsvDto dto : csvCourses) {

            validator.validate(dto);

            Course course = Course.builder()
                    .courseCode(dto.getCourseCode())
                    .courseName(dto.getCourseName())
                    .duration(dto.getDuration())
                    .status(CourseStatus.valueOf(dto.getStatus().toUpperCase()))
                    .build();

            courses.add(course);
        }

        repository.saveAll(courses);
    }

}