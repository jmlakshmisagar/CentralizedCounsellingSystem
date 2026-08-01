package com.ccs.mapper;

import com.ccs.dto.response.CollegeCourseResponse;
import com.ccs.entity.CollegeCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollegeCourseMapper {

    @Mapping(source = "college.id", target = "collegeId")
    @Mapping(source = "college.collegeCode", target = "collegeCode")
    @Mapping(source = "college.collegeName", target = "collegeName")

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "course.courseCode", target = "courseCode")
    @Mapping(source = "course.courseName", target = "courseName")

    CollegeCourseResponse toResponse(CollegeCourse entity);

}