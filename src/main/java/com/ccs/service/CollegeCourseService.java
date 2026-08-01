package com.ccs.service;

import com.ccs.dto.request.CollegeCourseRequest;
import com.ccs.dto.response.CollegeCourseResponse;
import com.ccs.entity.College;
import com.ccs.entity.CollegeCourse;
import com.ccs.entity.Course;
import com.ccs.mapper.CollegeCourseMapper;
import com.ccs.repository.CollegeCourseRepository;
import com.ccs.repository.CollegeRepository;
import com.ccs.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollegeCourseService {

    private final CollegeCourseRepository repository;
    private final CollegeRepository collegeRepository;
    private final CourseRepository courseRepository;
    private final CollegeCourseMapper mapper;

    public CollegeCourseResponse create(CollegeCourseRequest request) {

        College college = collegeRepository.findById(request.getCollegeId())
                .orElseThrow(() -> new EntityNotFoundException("College not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        CollegeCourse entity = CollegeCourse.builder()
                .college(college)
                .course(course)
                .intake(request.getIntake())
                .status(request.getStatus())
                .build();

        return mapper.toResponse(repository.save(entity));
    }

    public List<CollegeCourseResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}