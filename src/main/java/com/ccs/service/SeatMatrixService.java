package com.ccs.service;

import com.ccs.dto.request.SeatMatrixRequest;
import com.ccs.dto.response.SeatMatrixResponse;
import com.ccs.entity.CollegeCourse;
import com.ccs.entity.ReservationCategory;
import com.ccs.entity.SeatMatrix;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.SeatMatrixMapper;
import com.ccs.repository.CollegeCourseRepository;
import com.ccs.repository.ReservationCategoryRepository;
import com.ccs.repository.SeatMatrixRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatMatrixService {

    private final SeatMatrixRepository repository;
    private final CollegeCourseRepository collegeCourseRepository;
    private final ReservationCategoryRepository reservationCategoryRepository;
    private final SeatMatrixMapper mapper;

    @Transactional
    public SeatMatrixResponse create(SeatMatrixRequest request) {

        log.info(
                "Creating SeatMatrix: collegeCourseId={}, reservationCategoryId={}",
                request.getCollegeCourseId(),
                request.getReservationCategoryId());

        CollegeCourse collegeCourse =
                collegeCourseRepository.findById(request.getCollegeCourseId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "College Course not found with id : "
                                                + request.getCollegeCourseId()));

        ReservationCategory category =
                reservationCategoryRepository.findById(request.getReservationCategoryId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Reservation Category not found with id : "
                                                + request.getReservationCategoryId()));

        SeatMatrix seatMatrix = SeatMatrix.builder()
                .collegeCourse(collegeCourse)
                .reservationCategory(category)
                .totalSeats(request.getTotalSeats())
                .filledSeats(request.getFilledSeats())
                .availableSeats(request.getAvailableSeats())
                .status(request.getStatus())
                .build();

        SeatMatrix saved = repository.save(seatMatrix);

        log.info("SeatMatrix created successfully. Id={}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<SeatMatrixResponse> getAll() {

        log.info("Fetching all seat matrix records");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}