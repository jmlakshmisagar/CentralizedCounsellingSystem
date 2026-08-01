package com.ccs.repository;

import com.ccs.entity.CounsellingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounsellingSessionRepository
        extends JpaRepository<CounsellingSession, Long> {

    Optional<CounsellingSession> findBySessionName(String sessionName);

    boolean existsBySessionName(String sessionName);

}