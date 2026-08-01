package com.ccs.repository;

import com.ccs.entity.SeatAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatAllocationRepository
        extends JpaRepository<SeatAllocation, Long> {

    List<SeatAllocation> findByCounsellingRoundId(Long roundId);

    List<SeatAllocation> findByCandidateId(Long candidateId);

    Optional<SeatAllocation> findByCandidateIdAndCounsellingRoundId(
            Long candidateId,
            Long counsellingRoundId
    );

    List<SeatAllocation> findByCollegeCourseId(Long collegeCourseId);

}