package com.ccs.service;

import com.ccs.dto.request.CounsellingSessionRequest;
import com.ccs.dto.response.CounsellingSessionResponse;
import com.ccs.entity.CounsellingSession;
import com.ccs.mapper.CounsellingSessionMapper;
import com.ccs.repository.CounsellingSessionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounsellingSessionService {

    private final CounsellingSessionRepository repository;
    private final CounsellingSessionMapper mapper;

    public CounsellingSessionResponse create(CounsellingSessionRequest request) {

        if (repository.existsBySessionName(request.getSessionName())) {
            throw new IllegalArgumentException("Session already exists");
        }

        CounsellingSession entity = mapper.toEntity(request);

        return mapper.toResponse(repository.save(entity));
    }

    public List<CounsellingSessionResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CounsellingSessionResponse getById(Long id) {

        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Session not found"))
        );
    }

}