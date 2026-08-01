package com.ccs.repository;

import com.ccs.entity.Admission;
import com.ccs.enums.AdmissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRepository
        extends JpaRepository<Admission, Long> {

    Optional<Admission> findBySeatAllocationId(Long seatAllocationId);

    List<Admission> findByCandidateId(Long candidateId);

    List<Admission> findByStatus(AdmissionStatus status);

}