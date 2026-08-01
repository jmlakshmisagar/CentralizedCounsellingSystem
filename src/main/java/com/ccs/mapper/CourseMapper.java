package com.ccs.mapper;

import com.ccs.dto.request.CourseRequest;
import com.ccs.dto.response.CourseResponse;
import com.ccs.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseRequest request);

    CourseResponse toResponse(Course entity);

    void updateEntity(
            CourseRequest request,
            @MappingTarget Course entity
    );

}