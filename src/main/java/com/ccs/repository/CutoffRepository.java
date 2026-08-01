package com.ccs.repository;

import com.ccs.entity.Cutoff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CutoffRepository
        extends JpaRepository<Cutoff, Long> {

    List<Cutoff> findByCounsellingRoundId(Long counsellingRoundId);

    List<Cutoff> findByCollegeCourseId(Long collegeCourseId);

    Optional<Cutoff> findByCollegeCourseIdAndReservationCategoryIdAndCounsellingRoundId(
            Long collegeCourseId,
            Long reservationCategoryId,
            Long counsellingRoundId
    );

}