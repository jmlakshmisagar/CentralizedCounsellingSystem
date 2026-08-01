package com.ccs.mapper;

import com.ccs.dto.request.CourseRequest;
import com.ccs.dto.response.CourseResponse;
import com.ccs.entity.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseRequest request);

    CourseResponse toResponse(Course course);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(
            CourseRequest request,
            @MappingTarget Course course
    );

}