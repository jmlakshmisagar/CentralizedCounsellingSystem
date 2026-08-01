package com.ccs.repository;

import com.ccs.entity.CounsellingRound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounsellingRoundRepository
        extends JpaRepository<CounsellingRound, Long> {

    List<CounsellingRound> findByCounsellingSessionIdOrderByRoundNumber(
            Long sessionId
    );

}