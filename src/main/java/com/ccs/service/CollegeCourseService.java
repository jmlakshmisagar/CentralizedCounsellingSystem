package com.ccs.service;

import com.ccs.dto.request.CollegeCourseRequest;
import com.ccs.dto.response.CollegeCourseResponse;
import com.ccs.entity.College;
import com.ccs.entity.CollegeCourse;
import com.ccs.entity.Course;
import com.ccs.exception.DuplicateResourceException;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.CollegeCourseMapper;
import com.ccs.repository.CollegeCourseRepository;
import com.ccs.repository.CollegeRepository;
import com.ccs.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CollegeCourseService {

    private final CollegeCourseRepository repository;
    private final CollegeRepository collegeRepository;
    private final CourseRepository courseRepository;
    private final CollegeCourseMapper mapper;

    @Transactional
    public CollegeCourseResponse create(CollegeCourseRequest request) {

        log.info("Creating CollegeCourse : College={} Course={}",
                request.getCollegeId(),
                request.getCourseId());

        if (repository.existsByCollegeIdAndCourseId(
                request.getCollegeId(),
                request.getCourseId())) {

            throw new DuplicateResourceException(
                    "College Course mapping already exists.");
        }

        College college = collegeRepository.findById(request.getCollegeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "College not found with id : " + request.getCollegeId()));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id : " + request.getCourseId()));

        CollegeCourse entity = CollegeCourse.builder()
                .college(college)
                .course(course)
                .intake(request.getIntake())
                .status(request.getStatus())
                .build();

        CollegeCourse saved = repository.save(entity);

        log.info("CollegeCourse created successfully : {}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CollegeCourseResponse> getAll() {

        log.info("Fetching all CollegeCourse mappings");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}