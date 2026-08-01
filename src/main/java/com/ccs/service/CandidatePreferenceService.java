package com.ccs.service;

import com.ccs.dto.request.CandidatePreferenceRequest;
import com.ccs.dto.response.CandidatePreferenceResponse;
import com.ccs.entity.Candidate;
import com.ccs.entity.CandidatePreference;
import com.ccs.entity.College;
import com.ccs.entity.Course;
import com.ccs.mapper.CandidatePreferenceMapper;
import com.ccs.repository.CandidatePreferenceRepository;
import com.ccs.repository.CandidateRepository;
import com.ccs.repository.CollegeRepository;
import com.ccs.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatePreferenceService {

    private final CandidatePreferenceRepository repository;
    private final CandidateRepository candidateRepository;
    private final CollegeRepository collegeRepository;
    private final CourseRepository courseRepository;
    private final CandidatePreferenceMapper mapper;

    public CandidatePreferenceResponse create(
            CandidatePreferenceRequest request) {

        Candidate candidate = candidateRepository.findById(request.getCandidateId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Candidate not found"));

        College college = collegeRepository.findById(request.getCollegeId())
                .orElseThrow(() ->
                        new EntityNotFoundException("College not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Course not found"));

        CandidatePreference preference =
                CandidatePreference.builder()
                        .candidate(candidate)
                        .college(college)
                        .course(course)
                        .preferenceOrder(request.getPreferenceOrder())
                        .status(request.getStatus())
                        .build();

        return mapper.toResponse(
                repository.save(preference)
        );
    }

    public List<CandidatePreferenceResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}