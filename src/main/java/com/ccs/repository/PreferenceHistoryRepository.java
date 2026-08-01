package com.ccs.repository;

import com.ccs.entity.PreferenceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenceHistoryRepository
        extends JpaRepository<PreferenceHistory, Long> {

    List<PreferenceHistory> findByCandidateIdOrderByCreatedAtDesc(Long candidateId);

    List<PreferenceHistory> findByCounsellingRoundId(Long counsellingRoundId);

}