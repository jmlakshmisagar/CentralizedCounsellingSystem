package com.ccs.mapper;

import com.ccs.dto.response.AdmissionResponse;
import com.ccs.entity.Admission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdmissionMapper {

    @Mapping(source = "candidate.id", target = "candidateId")
    @Mapping(source = "candidate.candidateName", target = "candidateName")

    @Mapping(source = "counsellingRound.id", target = "counsellingRoundId")
    @Mapping(source = "counsellingRound.roundName", target = "roundName")

    @Mapping(source = "collegeCourse.college.id", target = "collegeId")
    @Mapping(source = "collegeCourse.college.collegeCode", target = "collegeCode")
    @Mapping(source = "collegeCourse.college.collegeName", target = "collegeName")

    @Mapping(source = "collegeCourse.course.id", target = "courseId")
    @Mapping(source = "collegeCourse.course.courseCode", target = "courseCode")
    @Mapping(source = "collegeCourse.course.courseName", target = "courseName")

    @Mapping(source = "reservationCategory.categoryCode", target = "reservationCategoryCode")
    AdmissionResponse toResponse(Admission admission);

}