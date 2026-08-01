package com.ccs.repository;

import com.ccs.entity.SeatMatrix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatMatrixRepository
        extends JpaRepository<SeatMatrix, Long> {

    Optional<SeatMatrix> findByCollegeCourseIdAndReservationCategoryId(
            Long collegeCourseId,
            Long reservationCategoryId
    );

}