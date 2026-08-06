package com.ccs.service;

import com.ccs.dto.request.CounsellingSessionRequest;
import com.ccs.dto.response.CounsellingSessionResponse;
import com.ccs.entity.CounsellingSession;
import com.ccs.exception.DuplicateResourceException;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.CounsellingSessionMapper;
import com.ccs.repository.CounsellingSessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounsellingSessionService {

    private final CounsellingSessionRepository repository;
    private final CounsellingSessionMapper mapper;

    @Transactional
    public CounsellingSessionResponse create(CounsellingSessionRequest request) {

        log.info("Creating counselling session {}", request.getSessionName());

        if (repository.existsBySessionName(request.getSessionName())) {
            throw new DuplicateResourceException(
                    "Counselling session already exists : " + request.getSessionName());
        }

        CounsellingSession entity = mapper.toEntity(request);

        CounsellingSession saved = repository.save(entity);

        log.info("Counselling session created successfully. Id={}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CounsellingSessionResponse> getAll() {

        log.info("Fetching all counselling sessions");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public CounsellingSessionResponse getById(Long id) {

        log.info("Fetching counselling session {}", id);

        CounsellingSession session = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Counselling session not found with id : " + id));

        return mapper.toResponse(session);
    }

}