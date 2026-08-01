package com.ccs.mapper;

import com.ccs.dto.response.CandidatePreferenceResponse;
import com.ccs.entity.CandidatePreference;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidatePreferenceMapper {

    @Mapping(source = "candidate.id", target = "candidateId")
    @Mapping(source = "candidate.candidateName", target = "candidateName")

    @Mapping(source = "college.id", target = "collegeId")
    @Mapping(source = "college.collegeCode", target = "collegeCode")
    @Mapping(source = "college.collegeName", target = "collegeName")

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "course.courseCode", target = "courseCode")
    @Mapping(source = "course.courseName", target = "courseName")

    CandidatePreferenceResponse toResponse(
            CandidatePreference entity
    );

}