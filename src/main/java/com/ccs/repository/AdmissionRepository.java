package com.ccs.repository;

import com.ccs.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {

    Optional<Admission> findByCandidateId(Long candidateId);

    boolean existsByCandidateId(Long candidateId);

    List<Admission> findByCounsellingRoundId(Long counsellingRoundId);

}