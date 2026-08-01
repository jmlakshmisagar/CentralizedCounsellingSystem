package com.ccs.repository;

import com.ccs.entity.SeatMatrix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatMatrixRepository
        extends JpaRepository<SeatMatrix, Long> {

    List<SeatMatrix> findByCollegeCourseId(Long collegeCourseId);

    List<SeatMatrix> findByCounsellingRoundId(Long counsellingRoundId);

    Optional<SeatMatrix> findByCollegeCourseIdAndReservationCategoryIdAndCounsellingRoundId(
            Long collegeCourseId,
            Long reservationCategoryId,
            Long counsellingRoundId
    );

}