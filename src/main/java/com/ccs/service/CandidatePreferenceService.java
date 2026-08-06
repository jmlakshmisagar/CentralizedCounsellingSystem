package com.ccs.service;

import com.ccs.dto.request.CandidatePreferenceRequest;
import com.ccs.dto.response.CandidatePreferenceResponse;
import com.ccs.entity.Candidate;
import com.ccs.entity.CandidatePreference;
import com.ccs.entity.College;
import com.ccs.entity.Course;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.CandidatePreferenceMapper;
import com.ccs.repository.CandidatePreferenceRepository;
import com.ccs.repository.CandidateRepository;
import com.ccs.repository.CollegeRepository;
import com.ccs.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidatePreferenceService {

    private final CandidatePreferenceRepository repository;
    private final CandidateRepository candidateRepository;
    private final CollegeRepository collegeRepository;
    private final CourseRepository courseRepository;
    private final CandidatePreferenceMapper mapper;

    @Transactional
    public CandidatePreferenceResponse create(
            CandidatePreferenceRequest request) {

        log.info("Creating preference for candidate {}", request.getCandidateId());

        Candidate candidate = candidateRepository.findById(request.getCandidateId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Candidate not found with id : " + request.getCandidateId()));

        College college = collegeRepository.findById(request.getCollegeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "College not found with id : " + request.getCollegeId()));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id : " + request.getCourseId()));

        CandidatePreference preference = CandidatePreference.builder()
                .candidate(candidate)
                .college(college)
                .course(course)
                .preferenceOrder(request.getPreferenceOrder())
                .status(request.getStatus())
                .build();

        CandidatePreference saved = repository.save(preference);

        log.info("Candidate preference created successfully. Id={}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CandidatePreferenceResponse> getAll() {

        log.info("Fetching all candidate preferences");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}