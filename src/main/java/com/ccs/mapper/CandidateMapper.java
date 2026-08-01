package com.ccs.mapper;

import com.ccs.dto.response.CandidateResponse;
import com.ccs.entity.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    @Mapping(source = "reservationCategory.id", target = "reservationCategoryId")
    @Mapping(source = "reservationCategory.categoryCode", target = "reservationCategoryCode")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "course.courseCode", target = "courseCode")
    CandidateResponse toResponse(Candidate candidate);

}