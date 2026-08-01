package com.ccs.service.impl;

import com.ccs.dto.request.CourseRequest;
import com.ccs.dto.response.CourseResponse;
import com.ccs.entity.Course;
import com.ccs.mapper.CourseMapper;
import com.ccs.repository.CourseRepository;
import com.ccs.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    @Override
    public CourseResponse createCourse(CourseRequest request) {

        Course course = courseMapper.toEntity(request);

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toResponse(savedCourse);
    }

    @Override
    public CourseResponse getCourseById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Course not found"));

        return courseMapper.toResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    public CourseResponse updateCourse(Long id,
                                       CourseRequest request) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Course not found"));

        courseMapper.updateEntity(request, course);

        Course updatedCourse = courseRepository.save(course);

        return courseMapper.toResponse(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {

        if (!courseRepository.existsById(id)) {
            throw new EntityNotFoundException("Course not found");
        }

        courseRepository.deleteById(id);
    }

}