package com.ccs.mapper;

import com.ccs.dto.response.SeatMatrixResponse;
import com.ccs.entity.SeatMatrix;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeatMatrixMapper {

    @Mapping(source = "collegeCourse.id", target = "collegeCourseId")
    @Mapping(source = "collegeCourse.college.collegeCode", target = "collegeCode")
    @Mapping(source = "collegeCourse.college.collegeName", target = "collegeName")
    @Mapping(source = "collegeCourse.course.courseCode", target = "courseCode")
    @Mapping(source = "collegeCourse.course.courseName", target = "courseName")
    @Mapping(source = "reservationCategory.categoryCode", target = "reservationCategoryCode")
    SeatMatrixResponse toResponse(SeatMatrix entity);

}