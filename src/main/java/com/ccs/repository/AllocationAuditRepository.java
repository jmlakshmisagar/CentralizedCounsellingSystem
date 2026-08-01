package com.ccs.repository;

import com.ccs.entity.AllocationAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocationAuditRepository
        extends JpaRepository<AllocationAudit, Long> {

    List<AllocationAudit> findByCandidateId(Long candidateId);

    List<AllocationAudit> findByCounsellingRoundId(Long counsellingRoundId);

}