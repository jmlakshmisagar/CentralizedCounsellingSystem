package com.ccs.service;

import com.ccs.dto.request.CounsellingRoundRequest;
import com.ccs.dto.response.CounsellingRoundResponse;
import com.ccs.entity.CounsellingRound;
import com.ccs.entity.CounsellingSession;
import com.ccs.exception.DuplicateResourceException;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.CounsellingRoundMapper;
import com.ccs.repository.CounsellingRoundRepository;
import com.ccs.repository.CounsellingSessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounsellingRoundService {

    private final CounsellingRoundRepository repository;
    private final CounsellingSessionRepository sessionRepository;
    private final CounsellingRoundMapper mapper;

    @Transactional
    public CounsellingRoundResponse create(CounsellingRoundRequest request) {

        log.info("Creating counselling round {}", request.getRoundName());

        if (repository.existsByRoundName(request.getRoundName())) {
            throw new DuplicateResourceException(
                    "Counselling round already exists : " + request.getRoundName());
        }

        CounsellingSession session = sessionRepository.findById(request.getCounsellingSessionId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Counselling session not found with id : "
                                        + request.getCounsellingSessionId()));

        CounsellingRound round = mapper.toEntity(request);
        round.setCounsellingSession(session);

        CounsellingRound saved = repository.save(round);

        log.info("Counselling round created successfully. Id={}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CounsellingRoundResponse> getAll() {

        log.info("Fetching all counselling rounds");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public CounsellingRoundResponse getById(Long id) {

        log.info("Fetching counselling round {}", id);

        CounsellingRound round = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Counselling round not found with id : " + id));

        return mapper.toResponse(round);
    }

    @Transactional
    public CounsellingRoundResponse update(
            Long id,
            CounsellingRoundRequest request) {

        log.info("Updating counselling round {}", id);

        CounsellingRound round = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Counselling round not found with id : " + id));

        CounsellingSession session = sessionRepository.findById(request.getCounsellingSessionId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Counselling session not found with id : "
                                        + request.getCounsellingSessionId()));

        mapper.updateEntity(request, round);
        round.setCounsellingSession(session);

        CounsellingRound updated = repository.save(round);

        log.info("Counselling round updated successfully {}", id);

        return mapper.toResponse(updated);
    }

    @Transactional
    public void delete(Long id) {

        log.info("Deleting counselling round {}", id);

        CounsellingRound round = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Counselling round not found with id : " + id));

        repository.delete(round);

        log.info("Counselling round deleted successfully {}", id);
    }
}