package com.ccs.service;

import com.ccs.dto.request.CandidateRequest;
import com.ccs.dto.response.CandidateResponse;
import com.ccs.entity.Candidate;
import com.ccs.entity.Course;
import com.ccs.entity.ReservationCategory;
import com.ccs.exception.DuplicateResourceException;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.CandidateMapper;
import com.ccs.repository.CandidateRepository;
import com.ccs.repository.CourseRepository;
import com.ccs.repository.ReservationCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository repository;
    private final CourseRepository courseRepository;
    private final ReservationCategoryRepository reservationCategoryRepository;
    private final CandidateMapper mapper;

    @Transactional
    public CandidateResponse create(CandidateRequest request) {

        log.info("Creating candidate : {}", request.getApplicationNumber());

        if (repository.existsByApplicationNumber(request.getApplicationNumber())) {
            throw new DuplicateResourceException(
                    "Application Number already exists : " + request.getApplicationNumber());
        }

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id : " + request.getCourseId()));

        ReservationCategory category = reservationCategoryRepository
                .findById(request.getReservationCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reservation Category not found with id : "
                                        + request.getReservationCategoryId()));

        Candidate candidate = Candidate.builder()
                .applicationNumber(request.getApplicationNumber())
                .candidateName(request.getCandidateName())
                .rank(request.getRank())
                .gender(request.getGender())
                .reservationCategory(category)
                .course(course)
                .mobileNumber(request.getMobileNumber())
                .email(request.getEmail())
                .status(request.getStatus())
                .build();

        Candidate saved = repository.save(candidate);

        log.info("Candidate created successfully. Id={}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CandidateResponse> getAll() {

        log.info("Fetching all candidates");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}