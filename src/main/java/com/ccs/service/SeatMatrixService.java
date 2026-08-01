package com.ccs.service;

import com.ccs.dto.request.SeatMatrixRequest;
import com.ccs.dto.response.SeatMatrixResponse;
import com.ccs.entity.CollegeCourse;
import com.ccs.entity.ReservationCategory;
import com.ccs.entity.SeatMatrix;
import com.ccs.mapper.SeatMatrixMapper;
import com.ccs.repository.CollegeCourseRepository;
import com.ccs.repository.ReservationCategoryRepository;
import com.ccs.repository.SeatMatrixRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatMatrixService {

    private final SeatMatrixRepository repository;
    private final CollegeCourseRepository collegeCourseRepository;
    private final ReservationCategoryRepository reservationCategoryRepository;
    private final SeatMatrixMapper mapper;

    public SeatMatrixResponse create(SeatMatrixRequest request) {

        CollegeCourse collegeCourse =
                collegeCourseRepository.findById(request.getCollegeCourseId())
                        .orElseThrow(() ->
                                new EntityNotFoundException("College Course not found"));

        ReservationCategory category =
                reservationCategoryRepository.findById(request.getReservationCategoryId())
                        .orElseThrow(() ->
                                new EntityNotFoundException("Reservation Category not found"));

        SeatMatrix seatMatrix = SeatMatrix.builder()
                .collegeCourse(collegeCourse)
                .reservationCategory(category)
                .totalSeats(request.getTotalSeats())
                .filledSeats(request.getFilledSeats())
                .availableSeats(request.getAvailableSeats())
                .status(request.getStatus())
                .build();

        return mapper.toResponse(repository.save(seatMatrix));
    }

    public List<SeatMatrixResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}