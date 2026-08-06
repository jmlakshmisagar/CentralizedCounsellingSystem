package com.ccs.repository;

import com.ccs.entity.CollegeCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeCourseRepository
        extends JpaRepository<CollegeCourse, Long> {

    List<CollegeCourse> findByCollegeId(Long collegeId);

    List<CollegeCourse> findByCourseId(Long courseId);

    boolean existsByCollegeIdAndCourseId(Long collegeId, Long courseId);

}