package com.ccs.repository;

import com.ccs.entity.CandidatePreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatePreferenceRepository
        extends JpaRepository<CandidatePreference, Long> {

    List<CandidatePreference> findByCandidateIdOrderByPriorityAsc(Long candidateId);

    boolean existsByCandidateIdAndPriority(Long candidateId, Integer priority);

    boolean existsByCandidateIdAndCollegeCourseId(
            Long candidateId,
            Long collegeCourseId
    );

}