package com.ccs.repository;

import com.ccs.entity.AllocationSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AllocationSummaryRepository
        extends JpaRepository<AllocationSummary, Long> {

    Optional<AllocationSummary> findByCounsellingRoundId(Long counsellingRoundId);

}