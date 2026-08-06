// src/main/java/com/ccs/service/impl/CourseServiceImpl.java

package com.ccs.service.impl;

import com.ccs.dto.request.CourseRequest;
import com.ccs.dto.response.CourseResponse;
import com.ccs.entity.Course;
import com.ccs.exception.DuplicateResourceException;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.CourseMapper;
import com.ccs.repository.CourseRepository;
import com.ccs.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    @Transactional
    public CourseResponse createCourse(CourseRequest request) {

        log.info("Creating course : {}", request.getCourseCode());

        if (courseRepository.existsByCourseCode(request.getCourseCode())) {
            throw new DuplicateResourceException(
                    "Course already exists with code : " + request.getCourseCode());
        }

        Course course = courseMapper.toEntity(request);

        Course savedCourse = courseRepository.save(course);

        log.info("Course created successfully. Id : {}", savedCourse.getId());

        return courseMapper.toResponse(savedCourse);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseResponse getCourseById(Long id) {

        log.info("Fetching course with id : {}", id);

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id : " + id));

        return courseMapper.toResponse(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> getAllCourses() {

        log.info("Fetching all courses");

        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public CourseResponse updateCourse(Long id, CourseRequest request) {

        log.info("Updating course : {}", id);

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id : " + id));

        courseMapper.updateEntity(request, course);

        Course updatedCourse = courseRepository.save(course);

        log.info("Course updated successfully : {}", id);

        return courseMapper.toResponse(updatedCourse);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {

        log.info("Deleting course : {}", id);

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id : " + id));

        courseRepository.delete(course);

        log.info("Course deleted successfully : {}", id);
    }
}