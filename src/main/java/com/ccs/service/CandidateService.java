package com.ccs.service;

import com.ccs.dto.request.CandidateRequest;
import com.ccs.dto.response.CandidateResponse;
import com.ccs.entity.Candidate;
import com.ccs.entity.Course;
import com.ccs.entity.ReservationCategory;
import com.ccs.mapper.CandidateMapper;
import com.ccs.repository.CandidateRepository;
import com.ccs.repository.CourseRepository;
import com.ccs.repository.ReservationCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository repository;
    private final CourseRepository courseRepository;
    private final ReservationCategoryRepository reservationCategoryRepository;
    private final CandidateMapper mapper;

    public CandidateResponse create(CandidateRequest request) {

        if (repository.existsByApplicationNumber(request.getApplicationNumber())) {
            throw new IllegalArgumentException("Application Number already exists");
        }

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        ReservationCategory category =
                reservationCategoryRepository.findById(request.getReservationCategoryId())
                        .orElseThrow(() -> new EntityNotFoundException("Category not found"));

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

        return mapper.toResponse(repository.save(candidate));
    }

    public List<CandidateResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}